package com.ecommerce.swiftcart.models;

import jakarta.persistence.*;

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private long price;

    @OneToOne
    private User user;
}
