package com.example.jpa.controller;


import com.example.jpa.dao.UserRepository;
import com.example.jpa.request.LoginRequest;
import com.example.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jpa.bean.User;

import java.util.List;

@RestController//控制返回的格式，写入Http响应头
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    List<User> findAll() {return userService.findAll();}
    @PostMapping("/login")
    ResponseEntity login(@RequestBody LoginRequest loginRequest){return userService.login(loginRequest);}
}
