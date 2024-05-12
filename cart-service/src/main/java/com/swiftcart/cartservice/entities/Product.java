package com.swiftcart.cartservice.entities;

import com.swiftcart.cartservice.dto.ProductDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int productId;
    private String name;
    private String details;
    private int discount;
    private int reviews;
    private int price;
    private int rating;
    private int type;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private ProductImage productImage;

    public Product(ProductDto productDto) {
        this.productId = productDto.getId();
        this.details = productDto.getDetails();
        this.discount = productDto.getDiscount();
        this.type = productDto.getType();
        this.name = productDto.getName();
        this.reviews = productDto.getReviews();
        this.rating = productDto.getRating();
        this.price = productDto.getPrice();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productId=" + productId +
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
