package com.sell.order.vo;

import lombok.Data;

/**
 * Http请求返回的最外层对象
 *
 * @param <T>
 */
@Data
public class ResultVo<T>
{
	/**
	 * 错误码
	 */
	private Integer code;

	/**
	 * 提示信息
	 */
	private String msg;

	/**
	 * 具体的内容
	 */
	private T data;
}
