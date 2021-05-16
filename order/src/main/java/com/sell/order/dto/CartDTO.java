package com.sell.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
