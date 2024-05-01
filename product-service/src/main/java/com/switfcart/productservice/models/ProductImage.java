package com.switfcart.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_image_id")
    private long id;
    private String name;
    private String type;
    private String path;
    private Timestamp timestamp;

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", path='" + path + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
