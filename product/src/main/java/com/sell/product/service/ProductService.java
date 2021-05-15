package com.sell.product.service;

import com.sell.product.entity.ProductInfo;

import java.util.List;

public interface ProductService
{
	/**
	 * 查询所有在架商品列表
	 *
	 * @return
	 */
	List<ProductInfo> findUpAll();
}
