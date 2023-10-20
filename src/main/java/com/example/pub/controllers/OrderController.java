package com.example.pub.controllers;
import com.example.pub.models.dtos.BuyDrinkDto;
import com.example.pub.services.DrinkService;
import com.example.pub.services.OrderService;
import com.example.pub.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
   private OrderService orderService;
   private UserService userService;
   private DrinkService drinkService;
   @Autowired
    public OrderController(OrderService orderService, UserService userService, DrinkService drinkService){
       this.orderService = orderService;
       this.userService = userService;
       this.drinkService = drinkService;
   }
   @PostMapping("/buy")
    public ResponseEntity<?> createOrder(@RequestBody BuyDrinkDto buyDrinkDto){
       try{
           return ResponseEntity.ok(orderService.createOrder(buyDrinkDto));
       } catch (Exception e){
           return ResponseEntity.badRequest().body(e.getMessage());
       }
   }
}
