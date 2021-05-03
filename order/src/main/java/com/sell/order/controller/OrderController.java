package com.sell.order.controller;

import com.sell.order.dto.OrderDTO;
import com.sell.order.enums.ResultCodeEnum;
import com.sell.order.exception.OrderException;
import com.sell.order.form.OrderForm;
import com.sell.order.service.OrderService;
import com.sell.order.utils.OrderUtil;
import com.sell.order.utils.ResultVoUtil;
import com.sell.order.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 订单 Controller
 */
@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 1. 参数检验
     * 2. 查询商品信息(调用商品服务)
     * 3. 计算总价
     * 4. 扣库存(调用商品服务)
     * 5. 订单入库
     */
    @PostMapping("/createOrder")
    public ResultVo createOrder(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new OrderException(ResultCodeEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }
        // orderForm -> orderDTO
        OrderDTO orderDTO = OrderUtil.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getDetails())) {
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultCodeEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);
        Map<String, String> data = new HashMap<>();
        data.put("orderId", result.getOrderId());
        return ResultVoUtil.success(data, "数据保存成功！");
    }
}
