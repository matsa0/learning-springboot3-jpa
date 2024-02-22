package com.learningjspring.course.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {
    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Instant moment;

    //Para fazer a annotation de relacionamento, você olha o lado da classe que você está
    @ManyToOne //Many Orders for One User - O JPA precisa saber
    @JoinColumn(name = "id_client") //especifica a coluna na tabela tb_order que mantém a chave estrangeira para a tabela User.
    private User client;

    public Order() {
    }

    public Order(long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Instant getMoment() {
        return moment;
    }
    public void setMoment(Instant moment) {
        this.moment = moment;
    }
    public User getClient() {
        return client;
    }
    public void setClient(User client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        Order other = (Order) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "";
    }
}
