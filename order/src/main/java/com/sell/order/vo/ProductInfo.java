package com.sell.order.vo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "product_info")
@Data
@Entity
public class ProductInfo
{
	/**
	 * 商品ID
	 */
	@Id
	private String productId;
	/**
	 * 名称
	 */
	private String productName;
	/**
	 * 价格
	 */
	private BigDecimal productPrice;
	/**
	 * 库存
	 */
	private Integer productStock;
	/**
	 * 商品描述
	 */
	private String productDescription;
	/**
	 * 图标
	 */
	private String productIcon;
	/**
	 * 商品状态
	 */
	private Integer productStatus;
	/**
	 * 类目编号
	 */
	private Integer categoryType;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更新时间
	 */
	private Date updateTime;
}
