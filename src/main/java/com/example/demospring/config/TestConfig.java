package com.example.demospring.config;

import com.example.demospring.entities.User;
import com.example.demospring.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile(value = "test")
public class TestConfig implements CommandLineRunner {
    private final UserRepository userRepository;

    @Autowired
    public TestConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        List<User> users = new ArrayList<>();

        users.add(new User(null, "Diogo", "diogo@mail.com", "+5500999999999", "12345"));
        users.add(new User(null, "John", "john@mail.com", "+5500999999999", "12345"));

        userRepository.saveAll(users);
    }
}
