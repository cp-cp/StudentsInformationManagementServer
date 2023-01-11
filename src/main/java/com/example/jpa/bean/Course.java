package com.example.jpa.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Course")
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     int id;
     String name;
     int credit;
     String number;
    @ManyToOne
    @JoinColumn(name="teacherId")
    private Teacher teacher;
}
