package com.example.jpa.controller;


import com.example.jpa.dao.UsernameRepository;
import com.example.jpa.service.UsernameService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.jpa.bean.Username;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController//控制返回的格式，写入Http响应头
@RequestMapping("/Usernames")
public class UsernameController {
    @Autowired
    UsernameService usernameService;

    @Autowired
    private UsernameRepository usernameRepository;

    @GetMapping("/all")
    List<Username> findAll() {
        return usernameService.findAll();
    }
}
