package com.example.ordermanagementsystem.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class Customer {

    public Customer() {
    }

    @Id
    private long id;
    @NotNull
    private String registrationCode;
    private String fullName;
    private String email;
    private String phoneNumber;
    @OneToMany
    @ToString.Exclude
    private List<Order> orders;
}
