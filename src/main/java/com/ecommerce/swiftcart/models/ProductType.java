package com.ecommerce.swiftcart.models;

public class ProductType {
    public int getId() {
        return id;
    }

    public ProductType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    int id;
    String name;

}
