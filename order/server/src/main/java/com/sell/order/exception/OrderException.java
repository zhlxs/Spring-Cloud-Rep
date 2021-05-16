package com.sell.order.exception;

import com.sell.order.enums.ResultCodeEnum;

public class OrderException extends RuntimeException
{

	private Integer code;

	public OrderException(Integer code, String message)
	{
		super(message);
		this.code = code;
	}

	public OrderException(ResultCodeEnum resultCodeEnum)
	{
		super(resultCodeEnum.getText());
		this.code = resultCodeEnum.getCode();
	}
}
