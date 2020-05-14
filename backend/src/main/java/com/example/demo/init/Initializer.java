package com.example.demo.init;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Initializer {
    private final UserService userService;
    @Autowired
    public Initializer(UserService userService) {
        this.userService = userService;
    }
    @PostConstruct
    public void init(){
        createUser("jim", "test");
    }

    private void createUser(String name, String email) {
        User user = new User(name, email);
        userService.saveUser(user);

    }
}
