package com.example.jpa.bean;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "Username")

public class Username {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String Username;
    String password;
}
