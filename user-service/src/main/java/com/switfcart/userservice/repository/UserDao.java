package com.switfcart.userservice.repository;

import com.switfcart.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
