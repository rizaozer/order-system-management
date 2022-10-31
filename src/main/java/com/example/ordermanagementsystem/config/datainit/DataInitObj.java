package com.example.ordermanagementsystem.config.datainit;

import lombok.Data;

import java.util.List;

@Data
public class DataInitObj {
    private List<Customer> customers;
    private List<Order> orders;
    private List<Product> products;
}
