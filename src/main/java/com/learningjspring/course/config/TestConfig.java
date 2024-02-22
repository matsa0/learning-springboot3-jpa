package com.learningjspring.course.config;
import com.learningjspring.course.entities.User;
import com.learningjspring.course.repositories.UserRepository;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration //classe de configuração
@Profile("test") //só vai rodar quando tiver no perfil de test(definido no application-test.properties)
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    //instancia o banco de dados no início da aplicação
    @SuppressWarnings("null")
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "88885555", "xulambada124");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "85562134", "4513asf");

        /*salva no banco de dados usando o UserRepository. Essa parte do código é destinada a inicializar dados de teste no banco de dados.*/
        userRepository.saveAll(Arrays.asList(u1, u2)); //userRepository herda de JpaRepository e tem todos os métodos CRUD
    }

}
