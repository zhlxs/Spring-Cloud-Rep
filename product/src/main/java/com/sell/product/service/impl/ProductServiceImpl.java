package com.sell.product.service.impl;

import com.sell.product.dto.CartDTO;
import com.sell.product.entity.ProductInfo;
import com.sell.product.enums.ProductStatusEnum;
import com.sell.product.enums.ResultEnum;
import com.sell.product.exp.ProductException;
import com.sell.product.repository.ProductInfoRepository;
import com.sell.product.service.ProductService;
import com.sell.product.vo.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService
{
	@Resource
	private ProductInfoRepository productInfoRepository;

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
	public ResultVo<?> decreaseStock(List<CartDTO> cartDTOS)
	{
		Assert.isTrue(!CollectionUtils.isEmpty(cartDTOS), "购物车数据为空");
		Optional<ProductInfo> optional = null;
		ProductInfo info = null;
		for (CartDTO item : cartDTOS)
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
			productInfoRepository.save(info);
		}
		return ResultVo.ok("操作成功");
	}
}
