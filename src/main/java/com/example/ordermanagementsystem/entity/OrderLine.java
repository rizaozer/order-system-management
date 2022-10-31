package com.example.ordermanagementsystem.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

@Data
@Embeddable
public class OrderLine {

    @Valid
    @ManyToOne
    private Product product;
    private int quantity;
}
