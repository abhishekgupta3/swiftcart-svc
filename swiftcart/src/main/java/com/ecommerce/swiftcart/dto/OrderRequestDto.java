package com.ecommerce.swiftcart.dto;

public class OrderRequestDto {
    private double cost;

    public OrderRequestDto(double cost) {
        this.cost = cost;
    }

    public OrderRequestDto() {
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
