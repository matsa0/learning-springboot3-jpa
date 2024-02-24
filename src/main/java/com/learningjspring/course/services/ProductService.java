package com.learningjspring.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningjspring.course.entities.Product;
import com.learningjspring.course.repositories.ProductRepository;

@Service
@SuppressWarnings("null")
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> productObj  = productRepository.findById(id);

        return productObj.get();
    }
}
