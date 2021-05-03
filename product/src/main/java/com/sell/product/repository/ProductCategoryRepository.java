package com.sell.product.repository;

import com.sell.product.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String>
{
    /**
     * 查询类目列表
     *
     * @param typeList
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> typeList);
}
