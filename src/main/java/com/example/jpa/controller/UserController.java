package com.example.jpa.controller;


import com.example.jpa.bean.Teacher;
import com.example.jpa.dao.UserRepository;
import com.example.jpa.request.LoginRequest;
import com.example.jpa.request.RegisterRequest;
import com.example.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jpa.bean.User;

import javax.validation.Valid;
import java.util.List;

@RestController//控制返回的格式，写入Http响应头
@RequestMapping("/users")
public class UserController {
    private static final int PAGE_SIZE = 4;
    @Autowired
    UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    List<User> findAll() {return userService.findAll();}
    @PostMapping("/login")
    ResponseEntity login(@Valid @RequestBody LoginRequest loginRequest){ return userService.login(loginRequest); }

    @PostMapping("/register")
    ResponseEntity register(@Valid @RequestBody RegisterRequest registerRequest){ return userService.register(registerRequest); }

    @GetMapping(value = "user/page/{pageNo}")
    public Page<User> getStudentWithPage(@PathVariable int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, PAGE_SIZE); // PAGE_SIZE 控制每一页最多的学生数量
        return userRepository.findAll(pageable);
    }
}
