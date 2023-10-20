package com.example.pub.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "orders")
@Data
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private int amount;
    private int price;
    @ManyToOne
    private User user;

    public Order(String productName, int amount, int price) {
        this.productName = productName;
        this.amount = amount;
        this.price = price;
    }

    public void setAmount(int amount) {
        if (amount > 0) {
            this.amount = amount;
        }
    }
    public void setPrice(int price) {
        if (price > 0) {
            this.price = price;
        }
    }

}
