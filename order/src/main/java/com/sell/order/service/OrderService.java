package com.sell.order.service;

import com.sell.order.dto.OrderDTO;

/**
 * 订单 Service
 */
public interface OrderService {

    /**
     * 创建订单
     * @param orderDTO
     * @return
     */
    OrderDTO create(OrderDTO orderDTO);
}
