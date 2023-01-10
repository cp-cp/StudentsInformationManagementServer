package com.example.jpa.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "user")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
}
