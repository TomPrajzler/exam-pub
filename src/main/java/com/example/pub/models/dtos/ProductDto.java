package com.example.pub.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long userId;
    private int amount;
    private int price;
}
