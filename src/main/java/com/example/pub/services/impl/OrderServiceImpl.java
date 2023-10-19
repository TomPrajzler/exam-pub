package com.example.pub.services.impl;

import com.example.pub.dtos.BuyDrinkDto;
import com.example.pub.models.Drink;
import com.example.pub.models.Order;
import com.example.pub.models.User;
import com.example.pub.repositories.DrinkRepository;
import com.example.pub.repositories.OrderRepository;
import com.example.pub.repositories.UserRepository;
import com.example.pub.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private DrinkRepository drinkRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserRepository userRepository, DrinkRepository drinkRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.drinkRepository = drinkRepository;
    }

    @Override
    public Order createOrder(BuyDrinkDto buyDrinkDto) {
        if(buyDrinkDto.getAmount() < 0){
            throw new IllegalArgumentException("Amount of drinks has to be more than 0");
        }
        Optional<User> optionalUser = userRepository.findById(buyDrinkDto.getUserId());
        Optional<Drink> optionalDrink = drinkRepository.findById(buyDrinkDto.getProductId());
        if (optionalUser.isEmpty()) {
            throw new IllegalArgumentException("User with this id doesn't exist");
        }
        if (optionalDrink.isEmpty()) {
            throw new IllegalArgumentException("Drink with this id doesn't exist");
        }
        if(optionalDrink.get().isForAdult() && !optionalUser.get().isAdult()){
            throw new IllegalArgumentException("User has to be over 18 years old to buy this drink");
        }
        if(optionalUser.get().getPocket() < optionalDrink.get().getPrice()* buyDrinkDto.getAmount()){
            throw new IllegalArgumentException("Insufficient balance");
        }
        Order order = new Order(optionalDrink.get().getProductName(),
                buyDrinkDto.getAmount(),
                optionalDrink.get().getPrice()* buyDrinkDto.getAmount());
        return orderRepository.save(order);
    }
}
