package com.ecommerce.swiftcart.repository;


import com.ecommerce.swiftcart.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
}
