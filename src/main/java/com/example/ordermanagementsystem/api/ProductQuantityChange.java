package com.example.ordermanagementsystem.api;

import lombok.Data;

@Data
public class ProductQuantityChange {

    private String productName;
    private int newQuantity;

}
