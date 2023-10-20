package com.example.pub.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "drink")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Drink {

    @Id
    @GeneratedValue
    private Long id;
    private String productName;
    private int price;
    private boolean isForAdult;



    public void setPrice(int price) {
        if(price > 0){
            this.price = price;
        }
    }
}
