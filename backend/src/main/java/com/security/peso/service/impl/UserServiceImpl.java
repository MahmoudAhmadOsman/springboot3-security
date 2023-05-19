package com.security.peso.service.impl;

import com.security.peso.model.User;
import com.security.peso.repository.UserRepository;
import com.security.peso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public String saveUser(User user) {

        User user1 = userRepository.save(user);
        if (user1 != null && user1.getName() != "") {
            return "User created successfully!";

        }
        return "Unable to create user!!";
    }

}
