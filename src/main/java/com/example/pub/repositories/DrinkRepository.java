package com.example.pub.repositories;

import com.example.pub.models.Drink;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkRepository extends CrudRepository<Drink, Long> {
    public List<Drink> findAll();
}
