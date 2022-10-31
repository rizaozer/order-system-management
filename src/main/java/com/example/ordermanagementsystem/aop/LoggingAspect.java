package com.example.ordermanagementsystem.aop;

import com.example.ordermanagementsystem.entity.Customer;
import com.example.ordermanagementsystem.entity.Order;
import com.example.ordermanagementsystem.entity.Product;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* org.springframework.data.jpa.repository.JpaRepository+.save(..))")
    public void saveUsingJpaRepository() {}

    @Before(value = "saveUsingJpaRepository() && args(product)")
    public void logProductBeforeSave(Product product) {
        System.out.println("===================================");
        System.out.println(product.getName());
        System.out.println("===================================");
    }

    @Before(value = "saveUsingJpaRepository() && args(toBeSaved)")
    public void logOrderBeforeSave(Order toBeSaved) {
        System.out.println("===================================");
        System.out.println(toBeSaved);
        System.out.println("===================================");
    }

    @Before(value = "saveUsingJpaRepository() && args(toBeSaved)")
    public void logCustomerBeforeSave(Customer toBeSaved) {
        System.out.println("===================================");
        System.out.println(toBeSaved.getFullName());
        System.out.println("===================================");
    }




}
