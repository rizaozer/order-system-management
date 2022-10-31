package com.example.ordermanagementsystem.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    private Long id;
    @ElementCollection(fetch = FetchType.EAGER)
    @Valid
    private List<OrderLine> orderLines;
    @ManyToOne
    @Valid
    private Customer customer;
    private LocalDate creationDate;
}
