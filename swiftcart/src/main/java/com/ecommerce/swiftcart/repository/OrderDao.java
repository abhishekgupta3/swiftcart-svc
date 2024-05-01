package com.ecommerce.swiftcart.repository;


import com.ecommerce.swiftcart.models.Order;
import com.ecommerce.swiftcart.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
    List<Order> findByUserId(int id);
}
