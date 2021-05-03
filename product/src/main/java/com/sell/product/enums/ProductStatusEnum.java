package com.sell.product.enums;

import lombok.Data;
import lombok.Getter;

/**
 * 商品状态枚举
 */
@Getter
public enum ProductStatusEnum {
    UP(0, "在架"), DOWN(1, "下架");
    private Integer code;
    private String text;

    ProductStatusEnum(Integer code, String text) {
        this.code = code;
        this.text = text;
    }

    public static ProductStatusEnum getCodeByText(String text) {
        for (ProductStatusEnum item : ProductStatusEnum.values()) {
            if (item.getText().equals(text)) {
                return item;
            }
        }
        return null;
    }

    public static ProductStatusEnum getTextByCode(String code) {
        for (ProductStatusEnum item : ProductStatusEnum.values()) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

}
