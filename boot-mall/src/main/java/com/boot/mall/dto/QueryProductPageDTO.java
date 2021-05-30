package com.boot.mall.dto;

import lombok.Data;

/**
 * 商品查询
 */
@Data
public class QueryProductPageDTO extends QueryPageDTO
{
	/**
	 * ID
	 */
	private Integer id;

	/**
	 * 商品名称
	 */
	private String productName;
}
