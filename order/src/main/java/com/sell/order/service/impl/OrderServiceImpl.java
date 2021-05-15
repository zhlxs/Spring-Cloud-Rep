package com.sell.order.service.impl;

import com.sell.order.dto.OrderDTO;
import com.sell.order.entity.OrderMaster;
import com.sell.order.enums.OrderStatusEnum;
import com.sell.order.enums.PayStatusEnum;
import com.sell.order.repository.OrderDetailRepository;
import com.sell.order.repository.OrderMasterRepository;
import com.sell.order.service.OrderService;
import com.sell.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderServiceImpl implements OrderService
{

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private OrderMasterRepository orderMasterRepository;

	@Override
	public OrderDTO create(OrderDTO orderDTO)
	{
		// 订单入库
		OrderMaster orderMaster = new OrderMaster();
		// 空属性也会被拷贝
		orderDTO.setOrderId(KeyUtil.genUniqueKey());
		BeanUtils.copyProperties(orderDTO, orderMaster);
		orderMaster.setOrderAmount(new BigDecimal(5));
		orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
		orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
		orderMasterRepository.save(orderMaster);
		return orderDTO;
	}
}
