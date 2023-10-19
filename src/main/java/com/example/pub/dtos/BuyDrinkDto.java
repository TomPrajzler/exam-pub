package com.example.pub.dtos;

import lombok.Data;

@Data
public class BuyDrinkDto {
    private Long userId;
    private Long productId;
    private int amount;

    public void setAmount(int amount) {
        if(amount > 0){
            this.amount = amount;
        }
    }
}
