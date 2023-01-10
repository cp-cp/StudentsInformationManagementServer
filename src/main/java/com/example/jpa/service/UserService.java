package com.example.jpa.service;

import com.example.jpa.bean.User;
import com.example.jpa.dao.UserRepository;
import com.example.jpa.request.LoginRequest;
import com.example.jpa.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public ResponseEntity<?> login(LoginRequest loginRequest) {
        if (userRepository.existsByUsername(loginRequest.getUsername())) {
            User user = userRepository.findByUsername(loginRequest.getUsername()).get();
            if (user.getPassword().equals(loginRequest.getPassword()))
                return ResponseEntity
                        .ok("login successfully!");
            else
                return ResponseEntity
                        .badRequest()
                        .body("Error: Password is wrong!");
        } else {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is not exist!");
        }
    }

    public ResponseEntity<?> register(RegisterRequest registerRequest) {
        if (userRepository.existsByUsername(registerRequest.getUsername()))
            return ResponseEntity
                    .badRequest()
                    .body("Error: The username has been registered!");

        User user = new User(registerRequest.getUsername()
                , registerRequest.getPassword()
                , registerRequest.getEmail());

        userRepository.save(user);

        return ResponseEntity
                .ok("Register successfully!");
    }
}
