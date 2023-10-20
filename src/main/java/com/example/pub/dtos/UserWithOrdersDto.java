package com.example.pub.dtos;

import com.example.pub.models.Order;
import com.example.pub.models.User;

import java.util.List;

public class UserWithOrdersDto {
    private Long id;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private int pocket;
    private List<Order> orders;
    public UserWithOrdersDto(User user){
        this.id = user.getId();
        this.name = user.getUsername();
        this.isActive = user.isActive();
        this.isAdult = user.calculateIsAdult(user.getDateOfBirth());
        this.pocket = user.getPocket();
        this.orders = user.getOrders();
    }
}
