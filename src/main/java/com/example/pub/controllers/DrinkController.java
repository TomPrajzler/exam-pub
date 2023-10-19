package com.example.pub.controllers;

import com.example.pub.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrinkController {
    private DrinkService drinkService;
    @Autowired
    public DrinkController(DrinkService drinkService){
        this.drinkService = drinkService;
    }
}
