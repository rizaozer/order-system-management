package com.example.ordermanagementsystem.config.datainit;

import lombok.Data;

@Data
public class Product {
    private long id;
    private String name;
    private int skuCode;
    private double unitPrice;
}
