package com.ecommerce.swiftcart.dto;

import java.util.Date;

public class OrderResponseDto {
    private Integer id;
    private String username;
    private double price;
    private Date date;

    public OrderResponseDto(Integer id, String username, double price, Date date) {
        this.id = id;
        this.username = username;
        this.price = price;
        this.date = date;
    }

    public OrderResponseDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
