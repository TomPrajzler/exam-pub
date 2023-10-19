package com.example.pub.services;

import com.example.pub.dtos.BuyDrinkDto;
import com.example.pub.models.Order;

public interface OrderService {
    Order createOrder(BuyDrinkDto buyDrinkDto);
}
