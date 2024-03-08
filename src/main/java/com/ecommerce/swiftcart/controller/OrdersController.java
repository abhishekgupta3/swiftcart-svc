package com.ecommerce.swiftcart.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("order")
@RestController
public class OrdersController {

    @GetMapping("/")
    public ResponseEntity getAllOrders() {
        return ResponseEntity.ok("");
    }
}
