package com.learningjspring.course.services;
import java.util.List;
import java.util.Optional;

import com.learningjspring.course.entities.User;
import com.learningjspring.course.repositories.UserRepository;
import com.learningjspring.course.services.exceptions.ResourceNotFoundException;

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

        //return objUser.get(); //retorna uma NoSuchElementException se o valor não for encontrado(exceção 500)
        return objUser.orElseThrow(() -> new ResourceNotFoundException(id)); //vai tentar dar o get(), se não der certo, lançará a exceção desejada
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(Long id, User user) {
        User entity = userRepository.getReferenceById(id); //pega o objeto referenciado pelo id passado
        updateData(entity, user);
        return userRepository.save(entity);
    }

    //atualiza a entidade com o novo objeto
    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
        //não atualizando password nem id
    }
}
