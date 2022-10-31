package com.example.ordermanagementsystem.controller;

import com.example.ordermanagementsystem.api.OrderSearch;
import com.example.ordermanagementsystem.api.ProductQuantityChange;
import com.example.ordermanagementsystem.entity.Customer;
import com.example.ordermanagementsystem.entity.Order;
import com.example.ordermanagementsystem.entity.Product;
import com.example.ordermanagementsystem.service.OrderService;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public void createOrder(@RequestBody Order order) {
        orderService.save(order);
    }

    @GetMapping("search/{date}")
    public List<Order> searchOrderByDate(@PathVariable LocalDate date) {
        return null;
    }

    @GetMapping("search/{customer}")
    public List<Order> searchOrderByCustomer(@PathVariable Customer customer) {
        return null;
    }

    @GetMapping("search/{product}")
    public List<Order> searchOrderByProduct(@PathVariable Product product) {
        return null;
    }

    /**
     *
     * @param orderSearch like: {
     *                              "key": "date" / "DATE" / "Product_scu" / ....
     *                              "value: "asdas" / 123 / "13.06.2022"
     *                          }
     * @return list of found orders.
     */
    @PostMapping("search")
    public List<Order> search(@RequestBody OrderSearch orderSearch) {
        return orderService.search(orderSearch);
    }

    @PostMapping ("change-quantity/{id}")
    public Order changeQuantity(@PathVariable long id, @RequestBody ProductQuantityChange quantityChange) {
        return orderService.changeQuantity(id, quantityChange.getProductName(), quantityChange.getNewQuantity());
    }

}
