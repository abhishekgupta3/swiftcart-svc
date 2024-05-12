package com.switfcart.orderservice.repository;

import com.switfcart.orderservice.entities.Order;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
    List<Order> findByUsername(String username);
}
