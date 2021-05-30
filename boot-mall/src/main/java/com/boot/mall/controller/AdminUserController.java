package com.boot.mall.controller;

import com.boot.mall.dto.LoginUserDTO;
import com.boot.mall.dto.QueryPageDTO;
import com.boot.mall.service.AdminUserService;
import com.boot.mall.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/mall/adminUserController")
public class AdminUserController
{
	@Autowired
	private AdminUserService adminUserService;

	@RequestMapping(value = "/login", method = { RequestMethod.POST })
	public Result login(@RequestBody LoginUserDTO otherParam)
	{
		return adminUserService.login(otherParam);
	}

	/**
	 * 用户分页查询
	 *
	 * @param otherParam
	 * @return
	 */
	@RequestMapping(value = "/queryPage", method = { RequestMethod.POST })
	public Result queryPage(@RequestBody QueryPageDTO otherParam)
	{
		return adminUserService.queryPage(otherParam);
	}
}
/*
1.json 分为两种类型:
(1)json 对象类型，即前端定义的Content type 为 application/x-www-form-urlencoded等
(2)json字符串类型，即前端定义的Content type 为 application/json
当前端定义为 application/x-www-form-urlencoded 时我们的接收如下：
这里使用的参数接收注解是：@RequestParam 用来接收此类型的json参数正常。
当前段定义为 application/json 时我们的接收如下：
这里使用的参数接收注解是：@RequestBody 可以正常接收json。
*/
