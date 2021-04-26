package com.example.demospring.resources;

import com.example.demospring.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Diogo", "diogo@mail.com", "+5500999999999", "123");
        return ResponseEntity.ok().body(user);
    }
}
