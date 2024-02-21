package com.learningjspring.course.resources;
import com.learningjspring.course.entities.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



//Recurso web controlado por um controller rest
@RestController
@RequestMapping(value = "/users")
public class UserResourcer {

    @GetMapping //mapeia a url para o método findAll
    public ResponseEntity<User> findAll() {
        User u = new User(1L, "Maria", "maria@gmail.com", "987565546", "123456");

        return ResponseEntity.ok().body(u);
    }
}
