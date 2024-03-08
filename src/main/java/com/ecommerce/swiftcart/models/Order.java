package com.ecommerce.swiftcart.models;

import jakarta.persistence.*;

@Entity
@Table(name = "transactions")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    private double price;

    @ManyToOne
    private User user;

    public Order(double price, User user) {
        this.price = price;
        this.user = user;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", price=" + price +
                ", user=" + user +
                '}';
    }
}
