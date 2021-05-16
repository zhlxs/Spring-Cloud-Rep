package com.sell.order.utils;

import com.sell.order.vo.ResultVo;

/**
 * 返回结果
 */
public class ResultVoUtil
{

	/**
	 * 请求成功
	 *
	 * @param data
	 * @return
	 */
	public static ResultVo success(Object data, String message)
	{
		ResultVo resultVo = new ResultVo();
		resultVo.setCode(0);
		resultVo.setMsg(message);
		resultVo.setData(data);
		return resultVo;
	}

}
