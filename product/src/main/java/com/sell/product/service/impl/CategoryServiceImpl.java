package com.sell.product.service.impl;

import com.sell.product.entity.ProductCategory;
import com.sell.product.repository.ProductCategoryRepository;
import com.sell.product.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> typeList) {
        return productCategoryRepository.findByCategoryTypeIn(typeList);
    }
}
