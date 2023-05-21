package com.security.controller;


import com.security.model.User;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN', 'MANAGER')")
    public List<User> findAllUser() {
        return userService.findAllUsers();
    }

    @PostMapping("/save")
    @PreAuthorize("hasAuthority('ADMIN','MANAGER')")
    public String saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @GetMapping("/{name}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<User> findUserByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

}
