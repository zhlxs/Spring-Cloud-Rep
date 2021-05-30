package com.boot.mall.dto;

import lombok.Data;

@Data
public class QueryPageDTO
{
	private Integer pageNum = 1;
	private Integer pageSize = 15;
}
