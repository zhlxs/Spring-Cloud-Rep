package com.sell.order.exception;

import com.sell.order.enums.ResultCodeEnum;
import com.sell.order.enums.ResultEnum;

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

	public OrderException(ResultEnum resultEnum)
	{
		super(resultEnum.getMessage());
		this.code = resultEnum.getCode();
	}
}
