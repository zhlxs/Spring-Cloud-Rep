package com.sell.eurake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 这就是一个注册中心
 * 既是Server，同时本身也是一个Clent端
 */
@SpringBootApplication
@EnableEurekaServer
public class EurakeApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(EurakeApplication.class, args);
	}

}
