package com.learningjspring.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningjspring.course.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
    
}
