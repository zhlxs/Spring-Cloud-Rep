package com.sell.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结订单"),
    CANCEL(2, "取消");

    private Integer code;
    private String text;

    OrderStatusEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }
}
