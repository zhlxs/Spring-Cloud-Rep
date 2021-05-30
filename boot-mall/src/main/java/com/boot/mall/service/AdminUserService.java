package com.boot.mall.service;

import com.boot.mall.dto.LoginUserDTO;
import com.boot.mall.dto.QueryPageDTO;
import com.boot.mall.util.Result;

public interface AdminUserService
{
	/**
	 * 登录
	 *
	 * @param otherParam
	 * @return
	 */
	public Result login(LoginUserDTO otherParam);

	/**
	 * 分页查询
	 *
	 * @param otherParam
	 * @return
	 */
	Result queryPage(QueryPageDTO otherParam);
}
