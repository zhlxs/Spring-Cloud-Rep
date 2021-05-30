package com.boot.mall.service.impl;

import com.boot.mall.dao.product.AdminProductMapper;
import com.boot.mall.dto.QueryProductPageDTO;
import com.boot.mall.entity.product.AdminProduct;
import com.boot.mall.service.AdminProductService;
import com.boot.mall.util.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class AdminProductServiceImpl implements AdminProductService
{
	@Autowired
	private AdminProductMapper adminProductMapper;

	/**
	 * 商品分页查询
	 *
	 * @param otherParam
	 * @return
	 */
	@Override
	public Result queryPage(QueryProductPageDTO otherParam)
	{
		PageHelper.startPage(otherParam.getPageNum(), otherParam.getPageSize());
		List<AdminProduct> list = adminProductMapper.selectByExp(otherParam);
		if (CollectionUtils.isEmpty(list))
		{
			return Result.ok("暂无数据");
		}
		return Result.ok(new PageInfo<>(list));
	}
}
