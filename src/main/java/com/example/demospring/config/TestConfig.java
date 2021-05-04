package com.example.demospring.config;

import com.example.demospring.entities.Category;
import com.example.demospring.entities.Order;
import com.example.demospring.entities.Product;
import com.example.demospring.entities.User;
import com.example.demospring.entities.enums.OrderStatus;
import com.example.demospring.repositories.CategoryRepository;
import com.example.demospring.repositories.OrderRepository;
import com.example.demospring.repositories.ProductRepository;
import com.example.demospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @Autowired
    public TestConfig(
            UserRepository userRepository,
            OrderRepository orderRepository,
            CategoryRepository categoryRepository,
            ProductRepository productRepository
        ) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) {

        Category c1 = new Category(null, "Eletronics");
        Category c2 = new Category(null, "Books");
        Category c3 = new Category(null, "Computers");

        Product p1 = new Product(null, "Lord of the rings", "description", 90.5f, "");
        Product p2 = new Product(null, "SmartTv", "description", 1005.0f, "");
        Product p3 = new Product(null, "MacBook", "description", 3540.99f, "");

        this.categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
        this.productRepository.saveAll(Arrays.asList(p1, p2, p3));

        p1.getCategories().add(c2);
        p2.getCategories().add(c1);
        p3.getCategories().addAll(Arrays.asList(c1, c3));

        this.productRepository.saveAll(Arrays.asList(p1, p2, p3));

        User u1 = new User(null, "Diogo", "diogo@mail.com", "+5500999999999", "12345");
        User u2 = new User(null, "John", "john@mail.com", "+5500999999999", "12345");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:03Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:01Z"), OrderStatus.CANCELED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-21T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        this.userRepository.saveAll(Arrays.asList(u1, u2));
        this.orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
