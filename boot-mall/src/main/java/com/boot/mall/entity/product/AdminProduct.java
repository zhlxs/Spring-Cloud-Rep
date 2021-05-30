package com.boot.mall.entity.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "admin_product")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminProduct
{
	/**
	 * 主键
	 */
	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "JDBC")
	private Integer id;

	/**
	 * 商品名称
	 */
	@Column(name = "PRODUCT_NAME")
	private String productName;

	/**
	 * 价格
	 */
	@Column(name = "PRICE")
	private BigDecimal price;

	/**
	 * 状态
	 */
	@Column(name = "STATUS")
	private String status;

	/**
	 * 图片地址
	 */
	@Column(name = "IMG_URL")
	private String imgUrl;

	/**
	 * 图片名称
	 */
	@Column(name = "IMG_NAME")
	private String imgName;

	/**
	 * 所属品类
	 */
	@Column(name = "PRODUCT_CATEGORY")
	private String productCategory;

	/**
	 * 库存
	 */
	@Column(name = "PRODUCT_NUM")
	private Integer productNum;

	/**
	 * 计量单位
	 */
	@Column(name = "PRODUCT_UNIT")
	private String productUnit;

	/**
	 * 入库日期
	 */
	@Column(name = "CREATE_TIME")
	private Date createTime;

	/**
	 * 更新时间
	 */
	@Column(name = "UPDATE_TIME")
	private Date updateTime;

	/**
	 * 商品描述
	 */
	@Column(name = "PRODUCT_DESC")
	private String productDesc;
}