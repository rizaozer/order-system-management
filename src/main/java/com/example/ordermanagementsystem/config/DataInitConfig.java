package com.example.ordermanagementsystem.config;

import com.example.ordermanagementsystem.config.datainit.DataInitObj;
import com.example.ordermanagementsystem.dao.CustomerRepository;
import com.example.ordermanagementsystem.dao.OrderRepository;
import com.example.ordermanagementsystem.dao.ProductRepository;
import com.example.ordermanagementsystem.entity.Customer;
import com.example.ordermanagementsystem.entity.Order;
import com.example.ordermanagementsystem.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.time.LocalDate;

@Configuration
public class DataInitConfig {

    @Bean
    public CommandLineRunner initData(OrderRepository orderRepository, CustomerRepository customerRepository,
                                      ProductRepository productRepository, ObjectMapper objectMapper, ModelMapper modelMapper) throws IOException {
        var resource = new ClassPathResource("static/data.json");
        var inputStream = resource.getInputStream();
        var dataInit = objectMapper.readValue(inputStream, DataInitObj.class);

        dataInit.getCustomers().stream()
                .map(customerDto -> modelMapper.map(customerDto, Customer.class))
                .forEach(customerRepository::save);
        dataInit.getProducts().stream()
                .map(product -> modelMapper.map(product, Product.class))
                .forEach(productRepository::save);
        dataInit.getOrders().stream()
                .map(orderDto -> {
                    var order = modelMapper.map(orderDto, Order.class);
                    if (order.getCreationDate() == null) {
                        order.setCreationDate(LocalDate.now());
                    }
                    return order;
                })
                .forEach(orderRepository::save);

        return args -> {
        };
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
