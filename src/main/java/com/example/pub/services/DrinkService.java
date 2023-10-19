package com.example.pub.services;

import com.example.pub.models.Drink;

import java.util.List;
import java.util.Optional;

public interface DrinkService {
    List<Drink> getAllDrinks();

    Optional<Drink> getDrinkById(Long id);
}
