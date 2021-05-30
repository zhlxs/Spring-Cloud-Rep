package com.boot.mall.service;

import com.boot.mall.dto.QueryProductPageDTO;
import com.boot.mall.util.Result;

public interface AdminProductService
{
	/**
	 * 商品分页查询
	 *
	 * @param otherParam
	 * @return
	 */
	Result queryPage(QueryProductPageDTO otherParam);
}
