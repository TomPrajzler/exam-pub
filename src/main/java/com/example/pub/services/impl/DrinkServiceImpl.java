package com.example.pub.services.impl;

import com.example.pub.repositories.DrinkRepository;
import com.example.pub.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrinkServiceImpl implements DrinkService {
    private DrinkRepository drinkRepository;
    @Autowired
    public DrinkServiceImpl (DrinkRepository drinkRepository){
        this.drinkRepository = drinkRepository;
    }
}
