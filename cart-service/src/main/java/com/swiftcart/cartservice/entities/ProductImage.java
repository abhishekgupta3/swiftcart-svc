package com.swiftcart.cartservice.entities;

import com.swiftcart.cartservice.dto.ProductImageDto;
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
    private long id;

    private long productImageId;
    private String name;
    private String type;
    private String path;
    private Timestamp timestamp;

    public ProductImage(ProductImageDto productImage) {
        this.productImageId = productImage.getId();
        this.name = productImage.getName();
        this.path = productImage.getPath();
        this.type = productImage.getType();
        this.timestamp = productImage.getTimestamp();
    }

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                ", productImageId=" + productImageId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", path='" + path + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
