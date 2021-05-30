package com.boot.mall.util;

import com.boot.mall.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常处理器
 */
@RestControllerAdvice
public class GlobalExceptionHandler
{
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 处理自定义异常
	 *
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = BusinessException.class)
	public Result exceptionHandler(HttpServletRequest req, BusinessException e)
	{
		logger.error("发生异常！原因是:", e);
		return Result.fail(e.getMessage());
	}
}
