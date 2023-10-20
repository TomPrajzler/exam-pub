package com.example.pub.services;

import com.example.pub.dtos.UserDto;
import com.example.pub.dtos.UserWithOrdersDto;
import com.example.pub.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<UserDto> getAllUsers();

    UserWithOrdersDto getUserById(Long id);
}
