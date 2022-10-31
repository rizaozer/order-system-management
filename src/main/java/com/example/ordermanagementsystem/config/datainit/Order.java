package com.example.ordermanagementsystem.config.datainit;

import lombok.Data;

import java.util.List;

@Data
public class Order {

    private List<OrderLine> orderLines;
    private long customerId;
}
