package com.swiftcart.cartservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer quantity;
    private int uId; // User ID
    private int pId; // Product Id

    @ManyToOne(cascade = CascadeType.ALL)
    private Product product; // Joined on product table index

    @ManyToOne(cascade = CascadeType.ALL)
    private User user; // Joined on user table index


    public Cart(Integer quantity, int uId, int pId, Product product, User user) {
        this.quantity = quantity;
        this.uId = uId;
        this.pId = pId;
        this.product = product;
        this.user = user;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", uId=" + uId +
                ", pId=" + pId +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}

