package com.learningjspring.course.config;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.learningjspring.course.entities.Category;
import com.learningjspring.course.entities.Order;
import com.learningjspring.course.entities.User;
import com.learningjspring.course.entities.enums.OrderStatus;
import com.learningjspring.course.repositories.CategoryRepository;
import com.learningjspring.course.repositories.OrderRepository;
import com.learningjspring.course.repositories.UserRepository;


@Configuration //classe de configuração
@Profile("test") //só vai rodar quando tiver no perfil de test(definido no application-test.properties)
public class TestConfig implements CommandLineRunner{

    //Injeção de dependência
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //instancia o banco de dados no início da aplicação
    @SuppressWarnings("null")
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "88885555", "xulambada124");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "85562134", "4513asf");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2); 
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category c1 = new Category(null, "Lunch");
        Category c2 = new Category(null, "Pizza");

        /*salva no banco de dados usando o UserRepository. Essa parte do código é destinada a inicializar dados de teste no banco de dados.*/
        userRepository.saveAll(Arrays.asList(u1, u2)); //userRepository herda de JpaRepository e tem todos os métodos CRUD
        orderRepository.saveAll(Arrays.asList(o1, o2, o3)); 
        categoryRepository.saveAll(Arrays.asList(c1, c2));
    }

}
