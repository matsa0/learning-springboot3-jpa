package com.learningjspring.course.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningjspring.course.entities.pk.OrderItemPk;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
    public static final long serialVersionUID = 1L;

    @EmbeddedId //Indica que a chave primária da entidade é uma chave composta e está representada por uma classe incorporável (no caso, OrderItemPk).
    private OrderItemPk id = new OrderItemPk(); //quando usa-se id composto, é necessário instanciá-la
    private Integer quantity;
    private double price;

    public OrderItem() {
    }

    public OrderItem(Order order, Product product, Integer quantity, double price) {
        id.setOrder(order);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }


    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setOrder(Order order) {
        id.setOrder(order);
    }

    @JsonIgnore
    public Order getOrder() {
        return id.getOrder();
    }

    public void setProduct(Product prodcut) {
        id.setProduct(prodcut);
    }
    public Product getProduct() {
        return id.getProduct();
    }

    public Double getSubTotal() {
        return price * quantity;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItem other = (OrderItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
