package com.security.peso.controller;


import com.security.peso.model.User;
import com.security.peso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping("/save")
    public String saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/all")

    public List<User> findAllUser() {
        return userService.findAllUsers();
    }


    @GetMapping("/{name}")
    public Optional<User> findUserByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

}
