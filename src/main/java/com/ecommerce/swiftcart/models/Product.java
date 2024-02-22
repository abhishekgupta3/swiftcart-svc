package com.ecommerce.swiftcart.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@EnableAutoConfiguration
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    String details;
    String type;
    int discount;
    int reviews;
    int price;
    int rating;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getDiscount() {
        return discount;
    }

    public int getReviews() {
        return reviews;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", reviews=" + reviews +
                ", rating=" + rating +
                '}';
    }

    public Product(String name, String details, String type, int discount, int reviews, int price, int rating) {
        this.name = name;
        this.details = details;
        this.type = type;
        this.discount = discount;
        this.reviews = reviews;
        this.price = price;
        this.rating = rating;
    }

    public Product() {
    }

    public Product(int id, String name, String details, String type, int price, int discount, int reviews, int rating) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.type = type;
        this.price = price;
        this.discount = discount;
        this.reviews = reviews;
        this.rating = rating;
    }
}
