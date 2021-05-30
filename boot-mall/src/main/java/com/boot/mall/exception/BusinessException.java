package com.boot.mall.exception;

public class BusinessException extends RuntimeException
{

	//异常信息
	private String message;

	public BusinessException()
	{

	}

	public BusinessException(String message)
	{
		super(message);
		this.message = message;
	}
}
