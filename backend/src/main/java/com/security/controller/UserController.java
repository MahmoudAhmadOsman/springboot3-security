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
@RequestMapping()
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/users/all")
//    @PreAuthorize("hasAuthority('ADMIN')") // only 1 authority such as ADMIN or USER
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')") // multiple authorities such as ['ADMIN', 'MANAGER','EMPLOYEE']
    public List<User> findAllUser() {

        return userService.findAllUsers();
    }

    @PostMapping("/users/save")
//    @PreAuthorize("hasAuthority('ADMIN')")
    @PreAuthorize("hasAnyAuthority('ADMIN','MANAGER')")
    public String saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }


    @GetMapping("/{name}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Optional<User> findUserByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

}
