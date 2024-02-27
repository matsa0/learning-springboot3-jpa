package com.learningjspring.course.services;
import java.util.List;
import java.util.Optional;

import com.learningjspring.course.entities.User;
import com.learningjspring.course.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//lida com a lógica de negócio relacionada a usuários
@Service //registra como componente service do spring, para injeção de dependência funcionar
@SuppressWarnings("null")
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByid(Long id) {
        Optional<User> objUser = userRepository.findById(id);

        return objUser.get();
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
