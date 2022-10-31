package com.example.ordermanagementsystem.config.datainit;

import lombok.Data;

@Data
public class Customer {

    private long id;
    private String registrationCode;
    private String fullName;
    private String email;
    private String phoneNumber;

}
