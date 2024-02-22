package com.learningjspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learningjspring.course.entities.User;

//A interface JpaRepository fornece métodos CRUD (Create, Read, Update, Delete) padrões e outras operações relacionadas ao banco de dados
public interface UserRepository extends JpaRepository<User, Long>{
    
}
