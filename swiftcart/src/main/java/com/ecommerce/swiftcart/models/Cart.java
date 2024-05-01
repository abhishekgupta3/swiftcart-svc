package com.ecommerce.swiftcart.models;

import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

    public Cart() {
    }

    public Cart(Integer quantity, Product product, User user) {
        this.quantity = quantity;
        this.product = product;
        this.user = user;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

