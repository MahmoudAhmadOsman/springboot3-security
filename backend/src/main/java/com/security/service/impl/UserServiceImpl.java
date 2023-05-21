package com.security.service.impl;

import com.security.model.User;
import com.security.repository.UserRepository;
import com.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Optional<User> findUserByName(String name) {
        return userRepository.findUserByName(name);
    }

    @Override
    public String saveUser(User user) {
        //encode  pass before saving to the database
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        User user1 = userRepository.save(user);
        if (user1 != null && user1.getName() != "") {
            return "User created successfully!";

        }
        return "Unable to create user!!";
    }

}
