package com.sell.product.dto;

import lombok.Data;

@Data
public class CartDTO
{

	/**
	 * 商品ID
	 */
	private String productId;

	/**
	 * 商品数量
	 */
	private Integer productQuantity;
}
