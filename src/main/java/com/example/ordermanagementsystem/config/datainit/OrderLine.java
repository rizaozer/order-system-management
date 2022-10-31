package com.example.ordermanagementsystem.config.datainit;

import lombok.Data;

@Data
public class OrderLine {

    private int quantity;
    private long productId;
}
