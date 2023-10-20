package com.example.pub.models.dtos;

import com.example.pub.models.User;

public class UserDto {
    private Long id;
    private String name;
    private boolean isActive;
    private boolean isAdult;
    private int pocket;
    public UserDto(User user){
        this.id = user.getId();
        this.name = user.getUsername();
        this.isActive = user.isActive();
        this.isAdult = user.calculateIsAdult(user.getDateOfBirth());
    }
}
