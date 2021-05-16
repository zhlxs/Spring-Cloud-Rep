package com.sell.product.repository;

import com.sell.product.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 数据
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String>
{
	/**
	 * 根据状态查询列表
	 *
	 * @param status
	 * @return
	 */
	List<ProductInfo> findByProductStatus(Integer status);

	/**
	 * 根据id集合查询商品列表
	 *
	 * @param ids
	 * @return
	 */
	List<ProductInfo> findByProductIdIn(List<String> ids);
}
