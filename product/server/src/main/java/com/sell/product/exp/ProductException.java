package com.sell.product.exp;

import com.sell.product.enums.ResultEnum;

public class ProductException extends RuntimeException
{
	private Integer code;

	public ProductException(Integer code, String msg)
	{
		super(msg);
		this.code = code;
	}

	public ProductException(ResultEnum resultEnum)
	{
		super(resultEnum.getText());
		this.code = resultEnum.getCode();
	}
}
