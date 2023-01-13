package com.example.jpa.dao;

import com.example.jpa.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Page<Student> findAll(Pageable pageable);
    List<Student> findAll();
    boolean existsById(int id);
    boolean existsByNumber(String Number);
    Optional<Student> findByNumber(String number);
    long deleteByNumber(String number);
}