package com.learningjspring.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningjspring.course.entities.Order;
import com.learningjspring.course.services.OrderService;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {    
    
    @Autowired
    private OrderService orderService;

    @GetMapping
    //RespondeEntity permite maior controle sobre respostas HTTP
    public ResponseEntity<List<Order>> findAll() {
        List<Order> listOrder = orderService.findAll();

        return ResponseEntity.ok().body(listOrder);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id) {
        Order objOrder = orderService.findById(id);

        return ResponseEntity.ok().body(objOrder);
    }

    
}
