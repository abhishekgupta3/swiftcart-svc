package com.ecommerce.swiftcart.models;

public class Product {
    int id;
    String name;
    String details;
    String type;
    int price;

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

    int discount;
    int reviews;

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

    int rating;

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
