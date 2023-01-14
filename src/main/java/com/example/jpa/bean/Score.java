package com.example.jpa.bean;

import com.example.jpa.dao.CourseRepository;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Score")
public class Score {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        int id;
        int score;
        @ManyToOne
        @JoinColumn(name = "courseId")
        private Course course;
        @ManyToOne
        @JoinColumn(name="studentId")
        private Student student;
}
