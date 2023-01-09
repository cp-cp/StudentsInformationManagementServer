package com.example.jpa.service;

import com.example.jpa.bean.Course;
import com.example.jpa.bean.Student;
import com.example.jpa.bean.Teacher;
import com.example.jpa.dao.CourseRepository;
import com.example.jpa.dao.StudentRepository;
import com.example.jpa.dao.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    @Autowired
    CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public String init() {
        String[] name = {"Alice", "Bob", "Charlie", "David", "Emily",
                "Frank", "Grace", "Henry", "Isabella", "John"};
        String[] college = {"Accountant", "Architect", "Engineer", "Lawyer", "Doctor", "Dentist", "Veterinarian", "Psychologist", "Developer", "Designer"};
        for (int i = 0; i < 10; i++) {
            Teacher teacher = new Teacher();
            teacher.setName(name[i]);
            teacher.setCollege(college[i]);
            teacherRepository.save(teacher);
        }
        return "initialize teachers successfully!";
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Optional<Teacher> findById(int id) {
        return teacherRepository.findById(id);
    }

    public String add(Teacher Teacher) {
        return null;
    }

    public String delete(int id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            courseRepository.deleteByTeacherId(id);
            return "成功删除!";
        } else {
            courseRepository.deleteByTeacherId(id);
            return "不存在这个序号的人";
        }

    }

    public Optional<Teacher> getById(int id) {
        return teacherRepository.findById(id);
    }

    public List<Course> AllCourses(int id) {
        List<Course> courses = courseRepository.findByTeacherId(id);
        return courses;
    }
}
