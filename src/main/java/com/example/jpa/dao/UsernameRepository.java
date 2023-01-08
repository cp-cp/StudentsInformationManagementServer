package com.example.jpa.dao;

import com.example.jpa.bean.Student;
import com.example.jpa.bean.Username;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsernameRepository extends JpaRepository<Username,Integer> {
    List<Username> findAll();
}
