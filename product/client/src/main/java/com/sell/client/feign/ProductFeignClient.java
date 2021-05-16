package com.sell.client.feign;

import com.sell.common.vo.DecreaseStockInput;
import com.sell.common.vo.ProductInfoOutput;
import com.sell.common.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
public interface ProductFeignClient
{
	@PostMapping("/product/listForOrder")
	List<ProductInfoOutput> listForOrder(@RequestBody List<String> ids);

	/**
	 * 扣除库存
	 *
	 * @param cartDTOS
	 * @return
	 */
	@PostMapping("/product/decreaseStock")
	ResultVo<?> decreaseStock(@RequestBody List<DecreaseStockInput> cartDTOS);
}
