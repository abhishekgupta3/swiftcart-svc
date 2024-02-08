package com.ecommerce.swiftcart.controller;

import com.ecommerce.swiftcart.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    ProductService productService;

    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/cart")
    public ResponseEntity getCart() {
        return ResponseEntity.ok(productService.getCartItems());
    }
}
