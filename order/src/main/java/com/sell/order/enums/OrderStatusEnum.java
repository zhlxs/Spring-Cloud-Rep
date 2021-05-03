package com.sell.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatus {
    NEW(0, "新订单"),
    FINISHED(1, "完结订单"),
    CANCEL(2, "取消");

    private Integer code;
    private String text;

    OrderStatus(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
}
