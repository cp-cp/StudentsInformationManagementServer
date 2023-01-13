package com.example.jpa.bean;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Data
@NoArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 5009021772979651472L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String number;
    String name;
    String gender;
    String college;
}
