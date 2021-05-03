package com.sell.order.enums;

import lombok.Getter;

@Getter
public enum ResultCodeEnum {

    PARAM_ERROR(1, "参数错误"),
    CART_EMPTY(2,"购物车为空");

    private Integer code;
    private String text;

    ResultCodeEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
}
