package com.ecommerce.swiftcart.services;


import com.ecommerce.swiftcart.dto.OrderRequestDto;
import com.ecommerce.swiftcart.dto.OrderResponseDto;
import com.ecommerce.swiftcart.models.Order;
import com.ecommerce.swiftcart.models.User;
import com.ecommerce.swiftcart.repository.OrderDao;
import com.ecommerce.swiftcart.repository.UserDao;
import com.ecommerce.swiftcart.utils.JwtUtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderDao orderDao;
    @Autowired
    JwtUtilsService jwtUtilsService;
    @Autowired
    UserDao userDao;

    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderDao.findAll();
        List<OrderResponseDto> orderResponseDtos = new ArrayList<>();

        orders.forEach(order -> orderResponseDtos.add(new OrderResponseDto(order.getId(), order.getUser().getUsername(), order.getPrice())));
        return orderResponseDtos;
    }

    public void addOrder(OrderRequestDto orderReq) throws Exception {
        String username = jwtUtilsService.getUsername();
        User user = userDao.findByUsername(username);

        Order order = new Order(orderReq.getCost(), user);

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
}
