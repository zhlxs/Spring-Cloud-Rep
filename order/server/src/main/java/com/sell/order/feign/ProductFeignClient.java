//package com.sell.order.feign;
//
//import com.sell.order.dto.CartDTO;
//import com.sell.order.vo.ProductInfo;
//import com.sell.order.vo.ResultVo;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@FeignClient(name = "product")
//public interface ProductFeignClient
//{
//	@PostMapping("/product/listForOrder")
//	List<ProductInfo> listForOrder(@RequestBody List<String> ids);
//
//	/**
//	 * 扣除库存
//	 *
//	 * @param cartDTOS
//	 * @return
//	 */
//	@PostMapping("/product/decreaseStock")
//	ResultVo<?> decreaseStock(@RequestBody List<CartDTO> cartDTOS);
//}
