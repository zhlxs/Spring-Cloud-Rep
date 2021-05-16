package com.sell.product.enums;

import lombok.Getter;

@Getter
public enum ResultEnum
{
	PRODUCT_NOT_EXIST(1, "商品不存在"),

	PRODUCT_STOCK_ERROR(2, "商品库存不足");

	private Integer code;
	private String text;

	ResultEnum(Integer code, String text)
	{
		this.code = code;
		this.text = text;
	}
}
