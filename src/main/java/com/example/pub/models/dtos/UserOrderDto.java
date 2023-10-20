package com.example.pub.models.dtos;

import lombok.Data;

@Data
public class UserOrderDto {
    private Long userId;
    private String product;
    private int price;
}
