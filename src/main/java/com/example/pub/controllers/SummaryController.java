package com.example.pub.controllers;

import com.example.pub.repositories.OrderRepository;
import com.example.pub.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/summary")
public class SummaryController {
    private OrderService orderService;

    public SummaryController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllOrdersForProductSummary() {
        return ResponseEntity.ok(orderService.getSummary());

    }

    @GetMapping("/product")
    public ResponseEntity<?> getAllOrdersForEachDrink() {
        return ResponseEntity.ok(orderService.getAllOrdersForEachDrink());
    }

    @GetMapping("/user")
    public ResponseEntity<?> getAllUserOrderSummaries() {
        return ResponseEntity.ok(orderService.getAllUserOrderSummaries());
    }

}
