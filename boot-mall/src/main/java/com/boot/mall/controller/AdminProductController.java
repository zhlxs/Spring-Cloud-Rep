package com.boot.mall.controller;

import com.boot.mall.dto.QueryProductPageDTO;
import com.boot.mall.service.AdminProductService;
import com.boot.mall.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品管理
 */
@RestController
@RequestMapping("/mall/adminProductController")
public class AdminProductController
{
	@Autowired
	private AdminProductService adminProductService;

	/**
	 * 商品分页查询
	 *
	 * @param otherParam
	 * @return
	 */
	@RequestMapping(value = "/queryPage", method = { RequestMethod.POST })
	public Result queryPage(@RequestBody QueryProductPageDTO otherParam)
	{
		return adminProductService.queryPage(otherParam);
	}
}
