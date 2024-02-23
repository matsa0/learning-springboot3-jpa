package com.learningjspring.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningjspring.course.entities.Category;
import com.learningjspring.course.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> listCategory = categoryService.findAll();

        return ResponseEntity.ok().body(listCategory);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findBydId(@PathVariable Long id) {
        Category categoryObj = categoryService.findById(id);

        return ResponseEntity.ok().body(categoryObj);
    }
}
