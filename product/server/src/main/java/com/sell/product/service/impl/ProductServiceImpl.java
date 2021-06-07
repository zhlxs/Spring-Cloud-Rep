package com.sell.product.service.impl;

import com.sell.common.vo.DecreaseStockInput;
import com.sell.common.vo.ProductInfoOutput;
import com.sell.product.entity.ProductInfo;
import com.sell.product.enums.ProductStatusEnum;
import com.sell.product.enums.ResultEnum;
import com.sell.product.exp.ProductException;
import com.sell.product.repository.ProductInfoRepository;
import com.sell.product.service.ProductService;
import com.sell.product.utils.JsonUtil;
import com.sell.product.vo.ResultVo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService
{
	@Resource
	private ProductInfoRepository productInfoRepository;
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Override
	public List<ProductInfo> findUpAll()
	{
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}

	@Override
	public ResultVo<?> listForOrder(List<String> productIds)
	{
		return ResultVo.ok(productInfoRepository.findByProductIdIn(productIds), "查询数据成功");
	}

	@Override
	public ResultVo<?> decreaseStock(List<DecreaseStockInput> decreaseStockInputs)
	{
		Assert.isTrue(!CollectionUtils.isEmpty(decreaseStockInputs), "购物车数据为空");
		List<ProductInfo> productInfoList = decreaseStockProcess(decreaseStockInputs);
		//发送mq消息
		List<ProductInfoOutput> productInfoOutputList = productInfoList.stream().map(e -> {
			ProductInfoOutput output = new ProductInfoOutput();
			BeanUtils.copyProperties(e, output);
			return output;
		}).collect(Collectors.toList());
		amqpTemplate.convertAndSend("productInfo", JsonUtil.toJson(productInfoOutputList));
		return ResultVo.ok("操作成功");
	}

	@Transactional
	public List<ProductInfo> decreaseStockProcess(List<DecreaseStockInput> decreaseStockInputList)
	{
		List<ProductInfo> productInfoList = new ArrayList<>();
		Optional<ProductInfo> optional = null;
		ProductInfo info = null;
		for (DecreaseStockInput item : decreaseStockInputList)
		{
			optional = productInfoRepository.findById(item.getProductId());
			if (!optional.isPresent())
			{
				throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
			}
			info = optional.get();
			Integer diff = info.getProductStock() - item.getProductQuantity();
			if (diff < 0)
			{
				throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
			}
			info.setProductStock(diff);
			// TODO优化
			// productInfoRepository.save(info);
			productInfoList.add(info);
		}
		productInfoRepository.saveAll(productInfoList);
		return productInfoList;
	}
}
