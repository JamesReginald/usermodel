package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    Iterable<User> findAll();

    void saveUser(User user);

    User findUserById(Long id);
}
