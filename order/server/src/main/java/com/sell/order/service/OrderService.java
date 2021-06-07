package com.sell.order.service;

import com.sell.order.dto.OrderDTO;

/**
 * 订单 Service
 */
public interface OrderService
{

	/**
	 * 创建订单
	 *
	 * @param orderDTO
	 * @return
	 */
	OrderDTO create(OrderDTO orderDTO);

	/**
	 * 完结订单(只能卖家操作)
	 *
	 * @param orderId
	 * @return
	 */
	OrderDTO finish(String orderId);
}
