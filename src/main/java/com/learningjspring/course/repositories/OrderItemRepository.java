package com.learningjspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningjspring.course.entities.OrderItem;
import com.learningjspring.course.entities.pk.OrderItemPk;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
    
}
