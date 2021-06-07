package com.sell.order.repository;

import com.sell.order.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String>
{
	List<OrderDetail> findByOrderId(String orderId);
}
