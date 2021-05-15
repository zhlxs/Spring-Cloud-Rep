package com.sell.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 这里需要注意一下，当前版本的代码启动时需要引入spring-boot-starter-web包，以往版本貌似没有此问题
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProductApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(ProductApplication.class, args);
	}

}
