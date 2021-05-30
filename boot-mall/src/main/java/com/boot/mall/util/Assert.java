package com.boot.mall.util;

import com.boot.mall.exception.BusinessException;

public class Assert
{
	public Assert()
	{
	}

	public static void isTrue(boolean expression, String message)
	{
		if (!expression)
		{
			throw new BusinessException(message);
		}
	}
}
