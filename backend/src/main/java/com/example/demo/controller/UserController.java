package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") //enables CORS
@RequestMapping(value="/userlist")
public class UserController {


    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getUsers(){
       Iterator<User> iterator= userService.findAll().iterator();
       List<User> users = new ArrayList<>();
       while (iterator.hasNext()){
           users.add(iterator.next());
       }
       return users;
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
       return userService.findUserById(id);
    }

    @PostMapping
    void addUser(@RequestBody User user){
        userService.saveUser(user);
    }
}
