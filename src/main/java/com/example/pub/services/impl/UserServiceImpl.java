package com.example.pub.services.impl;

import com.example.pub.models.dtos.UserDto;
import com.example.pub.models.dtos.UserWithOrdersDto;
import com.example.pub.models.User;
import com.example.pub.repositories.UserRepository;
import com.example.pub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            UserDto userDto = new UserDto(users.get(i));
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public UserWithOrdersDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isEmpty()){
            throw new IllegalArgumentException("User with this id doesn't exist");
        }else{
            UserWithOrdersDto userWithOrdersDto = new UserWithOrdersDto(optionalUser.get());
            return userWithOrdersDto;
        }

    }
}
