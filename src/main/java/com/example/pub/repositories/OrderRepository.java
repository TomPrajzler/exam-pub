package com.example.pub.repositories;

import com.example.pub.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
   List<Order> findAllByProductName(String productName);
   List<Order> findAllByUserId(Long id);
}
