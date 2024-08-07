package com.ecommerce.swiftcart.models;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@EnableAutoConfiguration
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    private String name;
    @Column(length = 5000)
    private String details;
    private int discount;
    private int reviews;
    private int price;
    private int rating;
    private int type;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_image_id")
    private ProductImage productImage;

    public Product() {
    }

    public Product(int id, String name, String details, int discount, int reviews, int price, int rating, int type, ProductImage productImage) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.discount = discount;
        this.reviews = reviews;
        this.price = price;
        this.rating = rating;
        this.type = type;
        this.productImage = productImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public ProductImage getProductImage() {
        return productImage;
    }

    public void setProductImage(ProductImage productImage) {
        this.productImage = productImage;
    }

    public Product(String name, String details, int discount, int reviews, int price, int rating, int type) {
        this.name = name;
        this.details = details;
        this.discount = discount;
        this.reviews = reviews;
        this.price = price;
        this.rating = rating;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", discount=" + discount +
                ", reviews=" + reviews +
                ", price=" + price +
                ", rating=" + rating +
                ", type=" + type +
                ", productImage=" + productImage +
                '}';
    }
}
