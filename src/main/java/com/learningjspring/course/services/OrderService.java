package com.learningjspring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningjspring.course.entities.Order;
import com.learningjspring.course.repositories.OrderRepository;

@Service
@SuppressWarnings("null")
public class OrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> objOrder = orderRepository.findById(id);

        return objOrder.get();
    }
}
