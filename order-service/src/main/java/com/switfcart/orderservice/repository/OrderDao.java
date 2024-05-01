package com.switfcart.orderservice.repository;


import com.switfcart.orderservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(int id);
}
