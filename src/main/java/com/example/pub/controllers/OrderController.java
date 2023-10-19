package com.example.pub.controllers;
import com.example.pub.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
   private OrderService orderService;
   @Autowired
    public OrderController(OrderService orderService){
       this.orderService = orderService;
   }
}
