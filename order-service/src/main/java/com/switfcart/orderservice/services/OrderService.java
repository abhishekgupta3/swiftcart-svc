package com.switfcart.orderservice.services;


import com.switfcart.orderservice.client.UserServiceClient;
import com.switfcart.orderservice.dto.OrderRequestDto;
import com.switfcart.orderservice.dto.OrderResponseDto;
import com.switfcart.orderservice.entities.Order;
import com.switfcart.orderservice.entities.User;
import com.switfcart.orderservice.repository.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;
    UserServiceClient userServiceClient;

    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderDao.findAll();
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();

        orders.forEach(order -> orderResponseDtos.add(new OrderResponseDto(order.getId(), order.getUser().getUsername(), order.getPrice(), order.getDate())));
        return orderResponseDtos;
    }

    public void addOrder(OrderRequestDto orderReq) throws Exception {
        User user = (User) userServiceClient.getCurrentUser().getBody();

        Order order = new Order(orderReq.getCost(), new Date(System.currentTimeMillis()), user);

        if (user != null) {
            try {
                orderDao.save(order);
            }
            catch (Exception err) {
                throw new Exception("Failed to save order " + err);
            }
        }
        else {
            throw new Exception("Some error occurred");
        }
    }

    public List<OrderResponseDto> getOrder() throws Exception {
        User user = (User) userServiceClient.getCurrentUser().getBody();

        List<Order> orders = null;
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();

        try {
            orders = orderDao.findByUserId(user.getId());
            orders.forEach(order -> orderResponseDtos.add(new OrderResponseDto(order.getId(), order.getUser().getUsername(), order.getPrice(), order.getDate())));
        }
        catch (Exception err) {
            throw new Exception("Failed to fetch user orders " + err);
        }
        return orderResponseDtos;
    }
}
