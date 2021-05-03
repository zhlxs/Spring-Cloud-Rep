package com.sell.order.utils;

import java.util.Random;

/**
 * 主键工具类
 */
public class KeyUtil {

    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
