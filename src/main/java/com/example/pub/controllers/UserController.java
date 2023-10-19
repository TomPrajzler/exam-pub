package com.example.pub.controllers;

import com.example.pub.models.User;
import com.example.pub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;
    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        Optional<User> optionalUser = userService.getUserById(id);
        if (optionalUser.isPresent()) {
            return ResponseEntity.ok().body(optionalUser);
        } else {
            return ResponseEntity.status(404).body("User with this id doesn't exist");
        }
    }
}
