package com.ecommerce.swiftcart.controller;

import com.ecommerce.swiftcart.services.ProductService;
import com.ecommerce.swiftcart.services.UserCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    @Autowired
    UserCartService userCartService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/cart")
    public ResponseEntity getCart() {
        return ResponseEntity.ok(userCartService.getCartItems());
    }
}
