package com.ecommerce.swiftcart.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "transactions")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    private double price;
    private Date date;

    @ManyToOne
    private User user;

    public Order(double price, Date date, User user) {
        this.price = price;
        this.date = date;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
