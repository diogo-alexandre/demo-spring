package com.example.demospring.config;

import com.example.demospring.entities.Order;
import com.example.demospring.entities.User;
import com.example.demospring.entities.enums.OrderStatus;
import com.example.demospring.repositories.OrderRepository;
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

    @Autowired
    public TestConfig(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) {

        User u1 = new User(null, "Diogo", "diogo@mail.com", "+5500999999999", "12345");
        User u2 = new User(null, "John", "john@mail.com", "+5500999999999", "12345");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:03Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:01Z"), OrderStatus.CANCELED, u2);
        Order o3 = new Order(null, Instant.parse("2019-07-21T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
    }
}
