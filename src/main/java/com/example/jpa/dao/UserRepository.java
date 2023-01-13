package com.example.jpa.dao;

import com.example.jpa.bean.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findAll();

    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    Optional<User> getByUsername(String username);
    Page<User> findAll(Pageable pageable);
}
