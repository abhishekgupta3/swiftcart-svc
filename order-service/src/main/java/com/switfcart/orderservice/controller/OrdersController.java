package com.switfcart.orderservice.controller;

import com.switfcart.orderservice.dto.OrderRequestDto;
import com.switfcart.orderservice.dto.OrderResponseDto;
import com.switfcart.orderservice.dto.ResponseDto;
import com.switfcart.orderservice.services.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("order")
@RestController
public class OrdersController {

    @Autowired
    OrderService orderService;
    Logger logger = LoggerFactory.getLogger(OrdersController.class);


    @GetMapping("/all")
    public ResponseEntity getAllOrders() {
        logger.info("/all Get all orders");
        List<OrderResponseDto> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("")
    public ResponseEntity getOrders(@RequestHeader String username) throws Exception {
        logger.info("get user order " + username);
        List<OrderResponseDto> orders = orderService.getOrder(username);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("")
    public ResponseEntity addOrder(@RequestBody OrderRequestDto orderReq, @RequestHeader String username) throws Exception {
        logger.info("add order " + orderReq + username);
        try {
            orderService.addOrder(orderReq, username);
        }
        catch (Exception err) {;
            logger.error("Some error occurred");
            throw new Exception(err);
        }
        return ResponseEntity.ok(new ResponseDto("Order placed successfully"));
    }
}
