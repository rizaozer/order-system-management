package com.example.ordermanagementsystem.service;

import com.example.ordermanagementsystem.api.OrderSearch;
import com.example.ordermanagementsystem.dao.OrderRepository;
import com.example.ordermanagementsystem.entity.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService extends AbstractService<Order, Long, OrderRepository> {

    public OrderService(OrderRepository repository) {
        super(repository);
    }


    // TODO: if product is not found inside of order, (so quantity cannot be changed) we want to throw ProductNotFoundException,
    //  and then we want to handle the exception iside controller to get some meaningful error message.
    @Transactional
    public Order changeQuantity(long id, String productName, int newQuantity) {
        Optional<Order> order = repository.findById(id);
        if(order.isEmpty()) {
            return null;
        }
        order.get().getOrderLines().stream()
                .filter(orderLine -> orderLine.getProduct().getName().equals(productName))
                .findFirst()
                .ifPresent(orderLine -> orderLine.setQuantity(newQuantity));

        return repository.save(order.get());
    }

    public List<Order> search(OrderSearch orderSearch) {
        return switch (orderSearch.getKey()) {
            case DATE -> repository.findAllByCreationDate(orderSearch.getDateValue());
            case CUSTOMER -> repository.findAllByCustomerName(orderSearch.getStringValue());
            case PRODUCT_NAME -> repository.findAllByProductName(orderSearch.getStringValue());
            case PRODUCT_SCU -> repository.findAllByProductSkuCode(orderSearch.getIntegerValue());
        };
    }
}










