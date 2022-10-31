package com.example.ordermanagementsystem.api;

import java.time.LocalDate;

public enum OrderSearchParam {
    DATE,
    CUSTOMER,
    PRODUCT_NAME,
    PRODUCT_SCU;


    public static OrderSearchParam from(String key) {
        for (var val : OrderSearchParam.values()) {
            if (val.name().equalsIgnoreCase(key)) {
                return val;
            }
        }
        return null;
    }

}
