package com.example.pub.repositories;

import com.example.pub.models.Drink;
import org.springframework.data.repository.CrudRepository;

public interface DrinkRepository extends CrudRepository<Drink, Long> {
}
