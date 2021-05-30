package com.boot.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.boot.mall.dao")
public class BootMallApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(BootMallApplication.class, args);
	}

}
