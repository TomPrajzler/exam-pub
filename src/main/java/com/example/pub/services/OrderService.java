package com.example.pub.services;

import com.example.pub.dtos.BuyDrinkDto;
import com.example.pub.dtos.SummaryDto;
import com.example.pub.models.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(BuyDrinkDto buyDrinkDto);

    List<SummaryDto> getSummary();
}
