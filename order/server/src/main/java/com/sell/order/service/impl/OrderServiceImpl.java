package com.sell.order.service.impl;

import com.sell.client.feign.ProductFeignClient;
import com.sell.common.vo.DecreaseStockInput;
import com.sell.common.vo.ProductInfoOutput;
import com.sell.order.dto.OrderDTO;
import com.sell.order.entity.OrderDetail;
import com.sell.order.entity.OrderMaster;
import com.sell.order.enums.OrderStatusEnum;
import com.sell.order.enums.PayStatusEnum;
import com.sell.order.enums.ResultEnum;
import com.sell.order.exception.OrderException;
import com.sell.order.repository.OrderDetailRepository;
import com.sell.order.repository.OrderMasterRepository;
import com.sell.order.service.OrderService;
import com.sell.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService
{

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private OrderMasterRepository orderMasterRepository;
	@Autowired
	private ProductFeignClient productFeignClient;

	/**
	 * 创建订单
	 *
	 * @param orderDTO
	 * @return
	 */
	@Override
	@Transactional
	public OrderDTO create(OrderDTO orderDTO)
	{
		String orderId = KeyUtil.genUniqueKey();
		// 查询商品信息
		List<String> productIdList = orderDTO.getDetails().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
		List<ProductInfoOutput> infos = productFeignClient.listForOrder(productIdList);
		Map<String, ProductInfoOutput> infoData = infos.stream().collect(Collectors.toMap(ProductInfoOutput::getProductId, Function.identity(), (k1, k2) -> k2));
		// 计算总价
		ProductInfoOutput info = null;
		BigDecimal total = new BigDecimal(BigInteger.ZERO);
		List<OrderDetail> addList = new ArrayList<>();
		for (OrderDetail detail : orderDTO.getDetails())
		{
			if (infoData.containsKey(detail.getProductId()))
			{
				// 一件商品的总价
				total = info.getProductPrice().multiply(new BigDecimal(detail.getProductQuantity()));
				BeanUtils.copyProperties(info, detail);
				detail.setOrderId(orderId);
				detail.setDetailId(KeyUtil.genUniqueKey());
				addList.add(detail);
			}
		}
		orderDetailRepository.saveAll(addList);
		//扣库存
		List<DecreaseStockInput> carts = orderDTO.getDetails().stream().map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
		productFeignClient.decreaseStock(carts);
		// 订单入库
		OrderMaster orderMaster = new OrderMaster();
		// 空属性也会被拷贝
		orderDTO.setOrderId(orderId);
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderAmount(total);
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		orderMasterRepository.save(orderMaster);
		return orderDTO;
	}

	@Override
	public OrderDTO finish(String orderId)
	{
		//1. 先查询订单
		Optional<OrderMaster> orderMasterOptional = orderMasterRepository.findById(orderId);
		if (!orderMasterOptional.isPresent())
		{
			throw new OrderException(ResultEnum.ORDER_NOT_EXIST);
		}

		//2. 判断订单状态
		OrderMaster orderMaster = orderMasterOptional.get();
		if (OrderStatusEnum.NEW.getCode() != orderMaster.getOrderStatus())
		{
			throw new OrderException(ResultEnum.ORDER_STATUS_ERROR);
		}

		//3. 修改订单状态为完结
		orderMaster.setOrderStatus(OrderStatusEnum.FINISHED.getCode());
		orderMasterRepository.save(orderMaster);

		//查询订单详情
		List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderId(orderId);
		if (CollectionUtils.isEmpty(orderDetailList))
		{
			throw new OrderException(ResultEnum.ORDER_DETAIL_NOT_EXIST);
		}

		OrderDTO orderDTO = new OrderDTO();
		BeanUtils.copyProperties(orderMaster, orderDTO);
		orderDTO.setDetails(orderDetailList);

		return orderDTO;
	}
}
