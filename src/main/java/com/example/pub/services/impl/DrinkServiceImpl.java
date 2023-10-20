package com.example.pub.services.impl;

import com.example.pub.models.Drink;
import com.example.pub.repositories.DrinkRepository;
import com.example.pub.services.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinkServiceImpl implements DrinkService {
    private DrinkRepository drinkRepository;
    @Autowired
    public DrinkServiceImpl (DrinkRepository drinkRepository){
        this.drinkRepository = drinkRepository;
    }

    @Override
    public List<Drink> getAllDrinks() {
       return drinkRepository.findAll();
    }


}
