package com.learningjspring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningjspring.course.entities.Category;
import com.learningjspring.course.repositories.CategoryRepository;

@Service
@SuppressWarnings("null")
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional <Category> categoryObj = categoryRepository.findById(id);

        return categoryObj.get();
    }
}
