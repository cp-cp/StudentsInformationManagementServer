package com.example.jpa.service;

import com.example.jpa.bean.Username;
import com.example.jpa.dao.UsernameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Service
public class UsernameService {
    @Autowired
    UsernameRepository usernameRepository;

    public List<Username> findAll() {
        return usernameRepository.findAll();
    }
}
