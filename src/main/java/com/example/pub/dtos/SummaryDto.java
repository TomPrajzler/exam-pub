package com.example.pub.dtos;

import com.example.pub.models.Drink;
import com.example.pub.models.Order;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SummaryDto {
    private String product;
    private int amount;
    private int unitPrice;
    private int summaryPrice;

    public SummaryDto(Order order, Drink drink) {
        this.product = drink.getProductName();
        this.amount = order.getAmount();
        this.unitPrice = drink.getPrice();
        this.summaryPrice = order.getPrice();
    }
}
