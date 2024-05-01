package com.ecommerce.swiftcart.controller;

import com.ecommerce.swiftcart.dto.OrderRequestDto;
import com.ecommerce.swiftcart.dto.OrderResponseDto;
import com.ecommerce.swiftcart.dto.ResponseDto;
import com.ecommerce.swiftcart.models.Order;
import com.ecommerce.swiftcart.models.User;
import com.ecommerce.swiftcart.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("order")
@RestController
public class OrdersController {

    @Autowired
    OrderService orderService;

    @GetMapping("/all")
    public ResponseEntity getAllOrders() {
        List<OrderResponseDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/")
    public ResponseEntity getOrders() throws Exception {
        List<OrderResponseDto> orders = orderService.getOrder();
        return ResponseEntity.ok(orders);
    }

    @PostMapping("")
    public ResponseEntity addOrder(@RequestBody OrderRequestDto orderReq) throws Exception {
        try {
            orderService.addOrder(orderReq);
        }
        catch (Exception err) {
            throw new Exception(err);
        }
        return ResponseEntity.ok(new ResponseDto("Order placed successfully"));
    }
}
