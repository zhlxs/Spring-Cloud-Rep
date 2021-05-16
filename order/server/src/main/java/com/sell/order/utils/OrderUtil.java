package com.sell.order.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sell.order.dto.OrderDTO;
import com.sell.order.entity.OrderDetail;
import com.sell.order.enums.ResultCodeEnum;
import com.sell.order.exception.OrderException;
import com.sell.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class OrderUtil
{

	private OrderUtil()
	{

	}

	public static OrderDTO convert(OrderForm orderForm)
	{
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setBuyerName(orderForm.getName());
		orderDTO.setBuyerPhone(orderForm.getPhone());
		orderDTO.setBuyerAddress(orderForm.getAddress());
		orderDTO.setBuyerOpenid(orderForm.getOpenid());

		List<OrderDetail> orderDetails = null;
		Gson gson = new Gson();
		try
		{
			orderDetails = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>()
			{
			}.getType());
		}
		catch (Exception e)
		{
			log.error("【json转换】错误，string={}", orderForm.getItems());
			throw new OrderException(ResultCodeEnum.PARAM_ERROR);
		}
		orderDTO.setDetails(orderDetails);
		return orderDTO;
	}
}
