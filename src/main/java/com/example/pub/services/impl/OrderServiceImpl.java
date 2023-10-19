package com.example.pub.services.impl;

import com.example.pub.dtos.BuyDrinkDto;
import com.example.pub.dtos.ProductDto;
import com.example.pub.dtos.SummaryDto;
import com.example.pub.dtos.UserOrderDto;
import com.example.pub.models.Drink;
import com.example.pub.models.Order;
import com.example.pub.models.User;
import com.example.pub.repositories.DrinkRepository;
import com.example.pub.repositories.OrderRepository;
import com.example.pub.repositories.UserRepository;
import com.example.pub.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public List<SummaryDto> getSummary() {
        List<Drink> allDrinks = drinkRepository.findAll();
        List<SummaryDto> summaryDtos = new ArrayList<>();
        for (int i = 0; i < allDrinks.size(); i++) {
            SummaryDto summaryDto = new SummaryDto();
            List<Order> getAllOrdersByDrinkName = orderRepository.findAllByProductName(allDrinks.get(i).getProductName());
            summaryDto.setProduct(allDrinks.get(i).getProductName());
            summaryDto.setUnitPrice(allDrinks.get(i).getPrice());
            int amount = 0;
            int summaryPrice = 0;
            for (int j = 0; j < getAllOrdersByDrinkName.size(); j++) {
                amount += getAllOrdersByDrinkName.get(j).getAmount();
                summaryPrice += getAllOrdersByDrinkName.get(j).getPrice();
            }
            summaryDto.setSummaryPrice(summaryPrice);
            summaryDto.setAmount(amount);
            summaryDtos.add(summaryDto);
        }
        return summaryDtos;
    }

    @Override
    public List<ProductDto> getAllOrdersForEachDrink() {
        List<Drink> allDrinks = drinkRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (int i = 0; i < allDrinks.size(); i++) {
            List<Order> orders = orderRepository.findAllByProductName(allDrinks.get(i).getProductName());
            for (int j = 0; j < orders.size(); j++) {
                ProductDto productDto = new ProductDto();
                productDto.setUserId(orders.get(j).getUser().getId());
                productDto.setAmount(orders.get(j).getAmount());
                productDto.setPrice(orders.get(j).getPrice());
                productDtos.add(productDto);
            }
        }
        return productDtos;
    }

    @Override
    public List<UserOrderDto> getAllUserOrderSummaries() {
        List<User> allUsers = userRepository.findAll();
        List<UserOrderDto> userOrderDtos = new ArrayList<>();
        for (int i = 0; i < allUsers.size(); i++) {
            List<Order> ordersOfUsers = orderRepository.findAllByUserId(allUsers.get(i).getId());
            for (int j = 0; j < ordersOfUsers.size(); j++) {
                UserOrderDto userOrderDto = new UserOrderDto();
                userOrderDto.setUserId(allUsers.get(i).getId());
                userOrderDto.setProduct(ordersOfUsers.get(j).getProductName());
                userOrderDto.setPrice(ordersOfUsers.get(j).getPrice());
                userOrderDtos.add(userOrderDto);
            }
        }
        return userOrderDtos;
    }
}
