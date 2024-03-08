package com.ecommerce.swiftcart.dto;

public class OrderResponseDto {
    private Integer id;
    private String username;
    private double price;

    public OrderResponseDto(Integer id, String username, double price) {
        this.id = id;
        this.username = username;
        this.price = price;
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
}
