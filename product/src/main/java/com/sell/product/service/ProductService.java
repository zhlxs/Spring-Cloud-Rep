package com.sell.product.service;

import com.sell.product.dto.CartDTO;
import com.sell.product.entity.ProductInfo;
import com.sell.product.vo.ResultVo;

import java.util.List;

public interface ProductService
{
	/**
	 * 查询所有在架商品列表
	 *
	 * @return
	 */
	List<ProductInfo> findUpAll();

	/**
	 * 查询商品列表根据商品id集合
	 *
	 * @param productIds
	 * @return
	 */
	ResultVo<?> listForOrder(List<String> productIds);

	/**
	 * 扣除库存
	 *
	 * @param cartDTOS
	 * @return
	 */
	ResultVo<?> decreaseStock(List<CartDTO> cartDTOS);
}
