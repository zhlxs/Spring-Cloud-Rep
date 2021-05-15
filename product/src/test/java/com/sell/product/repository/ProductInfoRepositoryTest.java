package com.sell.product.repository;

import com.sell.product.entity.ProductInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductInfoRepositoryTest
{

	@Autowired
	private ProductInfoRepository productInfoRepository;

	@Test
	void findByProductStatus()
	{
		List<ProductInfo> list = productInfoRepository.findByProductStatus(0);
		System.out.println(list.size());
	}
}