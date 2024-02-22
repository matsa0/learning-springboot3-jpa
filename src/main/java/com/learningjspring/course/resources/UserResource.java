package com.learningjspring.course.resources;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learningjspring.course.entities.User;
import com.learningjspring.course.services.UserService;

//Um controlador REST é uma classe ou componente em um aplicativo web que gerencia e responde a solicitações HTTP
@RestController
//rota
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;
    //Um endpoint é uma URL específica em que o controlador REST responde a solicitações. Mapeado para essa função 
    @GetMapping 
    public ResponseEntity<List<User>> findAll() {
        List<User> listUser = userService.findAll();

        return ResponseEntity.ok().body(listUser);
    }


    //aceita um id dentro da url
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) { //PathVariable pega o id que eu coloquei na url
        User userObj = userService.findByid(id);

        return ResponseEntity.ok().body(userObj);
    }
}

