package com.example.jpa.dao;

import com.example.jpa.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAll();
    boolean existsById(int id);
}