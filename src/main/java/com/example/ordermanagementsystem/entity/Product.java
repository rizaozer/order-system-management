package com.example.ordermanagementsystem.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Product {

    @Id
    @NotNull
    private long id;
    @Length(max = 500, min = 2)
    @NotNull
    private String name;
    @Min(1)
    @Max(9999)
    @NotNull
    private int skuCode;
    @NotNull
    @Max(10_000_000)
    private double unitPrice;
}
