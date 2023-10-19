package com.example.pub.dtos;

import lombok.Data;

@Data
public class UserOrderDto {
    private Long userId;
    private String product;
    private int price;
}
