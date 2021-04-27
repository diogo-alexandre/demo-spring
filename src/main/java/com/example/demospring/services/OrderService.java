package com.example.demospring.services;

import com.example.demospring.entities.Order;
import com.example.demospring.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = this.orderRepository.findById(id);
        return order.get();
    }
}
