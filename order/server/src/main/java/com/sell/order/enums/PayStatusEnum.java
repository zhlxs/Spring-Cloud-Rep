package com.sell.order.enums;

import lombok.Getter;

@Getter
public enum PayStatusEnum
{
	WAIT(0, "等待支付"), END(1, "支付成功");

	private Integer code;
	private String text;

	PayStatusEnum(Integer code, String text)
	{
		this.code = code;
		this.text = text;
	}
}
