package com.boot.mall.dao.product;

import com.boot.mall.dto.QueryProductPageDTO;
import com.boot.mall.entity.product.AdminProduct;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AdminProductMapper extends Mapper<AdminProduct>
{
	/**
	 * 商品分页查询
	 *
	 * @param params
	 * @return
	 */
	List<AdminProduct> selectByExp(QueryProductPageDTO params);
}