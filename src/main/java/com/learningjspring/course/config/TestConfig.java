package com.learningjspring.course.config;
import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.learningjspring.course.entities.Category;
import com.learningjspring.course.entities.Order;
import com.learningjspring.course.entities.Product;
import com.learningjspring.course.entities.User;
import com.learningjspring.course.entities.enums.OrderStatus;
import com.learningjspring.course.repositories.CategoryRepository;
import com.learningjspring.course.repositories.OrderRepository;
import com.learningjspring.course.repositories.ProductRepository;
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

    @Autowired
    private ProductRepository productRepository;



    //instancia o banco de dados no início da aplicação
    @SuppressWarnings("null")
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "88885555", "xulambada124");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "85562134", "4513asf");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1); 
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.SHIPPED, u2); 
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
        Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
        Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
        Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
        Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
     

        /*salva no banco de dados usando o UserRepository. Essa parte do código é destinada a inicializar dados de teste no banco de dados.*/
        userRepository.saveAll(Arrays.asList(u1, u2)); //userRepository herda de JpaRepository e tem todos os métodos CRUD
        orderRepository.saveAll(Arrays.asList(o1, o2, o3)); 
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        //associação produto -> categorias
        p1.getCategories().add(c2); //p1 faz parte da categoria c2(books)
        p2.getCategories().add(c1);
        p3.getCategories().add(c3);
        p4.getCategories().add(c3);
        p5.getCategories().add(c2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
    }

}
