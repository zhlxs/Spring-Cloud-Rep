package com.sell.product.service;

import com.sell.product.entity.ProductCategory;

import java.util.List;

public interface CategoryService
{
	/**
	 * 查询类目列表
	 *
	 * @param typeList
	 * @return
	 */
	List<ProductCategory> findByCategoryTypeIn(List<Integer> typeList);
}
