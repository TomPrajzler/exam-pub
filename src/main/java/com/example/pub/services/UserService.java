package com.example.pub.services;

import com.example.pub.models.dtos.UserDto;
import com.example.pub.models.dtos.UserWithOrdersDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();

    UserWithOrdersDto getUserById(Long id);
}
