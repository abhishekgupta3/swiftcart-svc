package com.switfcart.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@Entity
@EnableAutoConfiguration
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
