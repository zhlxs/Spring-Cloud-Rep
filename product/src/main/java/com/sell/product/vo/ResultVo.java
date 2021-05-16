package com.sell.product.vo;

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

	public static ResultVo<?> ok(Object data, String msg)
	{
		ResultVo res = new ResultVo<>();
		res.setMsg(msg);
		res.setCode(0);
		res.setData(data);
		return res;
	}

	public static ResultVo<?> ok(String msg)
	{
		ResultVo res = new ResultVo<>();
		res.setMsg(msg);
		res.setCode(0);
		return res;
	}

	public static ResultVo<?> fail(String msg)
	{
		ResultVo res = new ResultVo<>();
		res.setMsg(msg);
		res.setCode(-1);
		return res;
	}
}
