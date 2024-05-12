package com.swiftcart.cartservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private int id;
    private String name;
    private String details;
    private int discount;
    private int reviews;
    private int price;
    private int rating;
    private int type;
    private ProductImageDto productImage;

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

