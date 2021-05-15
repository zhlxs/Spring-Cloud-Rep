package com.sell.product.service.impl;

import com.sell.product.entity.ProductInfo;
import com.sell.product.enums.ProductStatusEnum;
import com.sell.product.repository.ProductInfoRepository;
import com.sell.product.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{
	@Resource
	private ProductInfoRepository productInfoRepository;

	@Override
	public List<ProductInfo> findUpAll()
	{
		return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
	}
}
