package com.example.ordermanagementsystem.controller;

import com.example.ordermanagementsystem.entity.Product;
import com.example.ordermanagementsystem.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    /**
     * {
     *     name:
     *     scuCode:
     *     shortName: "qweqweqwe"
     * }
     * @param product
     */
    @PostMapping
    public String createProduct(@RequestBody @Valid Product product) {
        var p = productService.save(product);
        if (p != null) {
            return "Product '%s' is created".formatted(p.getId());
        }
        return "Error";
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

}
