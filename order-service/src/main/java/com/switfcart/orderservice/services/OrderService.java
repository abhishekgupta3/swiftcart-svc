package com.switfcart.orderservice.services;


import com.switfcart.orderservice.dto.OrderRequestDto;
import com.switfcart.orderservice.dto.OrderResponseDto;
import com.switfcart.orderservice.entities.Order;
import com.switfcart.orderservice.repository.OrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;
    Logger logger = LoggerFactory.getLogger(OrderService.class);


    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderDao.findAll();
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();

        orders.forEach(order -> orderResponseDtos.add(new OrderResponseDto(order.getId(), order.getUsername(), order.getPrice(), order.getDate())));
        return orderResponseDtos;
    }

    public void addOrder(OrderRequestDto orderReq, String username) throws Exception {

        Order order = new Order(orderReq.getCost(), new Date(System.currentTimeMillis()), username);
        logger.info("ADD ORDER " + username + order);

        if (username != null) {
            try {
                orderDao.save(order);
            }
            catch (Exception err) {
                logger.error("Failed to save order ");
                throw new Exception("Failed to save order " + err);
            }
        }
        else {
            throw new Exception("Some error occurred");
        }
    }

    public List<OrderResponseDto> getOrder(String username) throws Exception {

        List<Order> orders = null;
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();

        logger.info("Get order " + username);

        try {
            orders = orderDao.findByUsername(username);
            orders.forEach(order -> orderResponseDtos.add(new OrderResponseDto(order.getId(), order.getUsername(), order.getPrice(), order.getDate())));
        }
        catch (Exception err) {
            logger.error("Failed to fetch user orders ");
            throw new Exception("Failed to fetch user orders " + err);
        }
        return orderResponseDtos;
    }
}
