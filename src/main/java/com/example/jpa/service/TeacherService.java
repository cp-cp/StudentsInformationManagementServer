package com.example.jpa.service;

import com.example.jpa.bean.Course;
import com.example.jpa.bean.Student;
import com.example.jpa.bean.Teacher;
import com.example.jpa.dao.CourseRepository;
import com.example.jpa.dao.StudentRepository;
import com.example.jpa.dao.TeacherRepository;
import com.example.jpa.request.InsertTeacherRequest;
import com.example.jpa.request.ModifyTeacherRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        Random random=new Random();
        String[] name = {"Alice", "Bob", "Charlie", "David", "Emily",
                "Frank", "Grace", "Henry", "Isabella", "John"};
        String[] college = {"Accountant", "Architect", "Engineer", "Lawyer", "Doctor", "Dentist", "Veterinarian", "Psychologist", "Developer", "Designer"};
        for (int i = 0; i < 10; i++) {
            Teacher teacher = new Teacher();
            teacher.setName(name[i]);
            teacher.setCollege(college[i]);
            if(random.nextInt(2)==1)teacher.setGender("男");
            else teacher.setGender("女");
            Integer number=random.nextInt(10000) + 0220210000;
            teacher.setNumber(number.toString());
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

    public ResponseEntity add(InsertTeacherRequest teacherRequest) {
        if(teacherRepository.existsByNumber(teacherRequest.getNumber()))
        {
            return ResponseEntity
                    .badRequest()
                    .body("Error: The teacher has been existed!");
        }
        else
        {
            Teacher teacher=new Teacher();
            teacher.setCollege(teacherRequest.getCollege());
            teacher.setName(teacherRequest.getName());
            teacher.setGender(teacherRequest.getGender());
            teacher.setNumber(teacherRequest.getNumber());
            teacherRepository.save(teacher);
            return ResponseEntity.ok("Success!");
        }
    }

    public ResponseEntity delete(String number) {
        if (teacherRepository.existsByNumber(number)) {
            teacherRepository.deleteByNumber(number);
            courseRepository.deleteByTeacherNumber(number);
            return ResponseEntity.ok("Success!");
        } else {
            return ResponseEntity
                    .badRequest()
                    .body("Error: No match!");
        }
    }

    public Optional<Teacher> getById(int id) {
        return teacherRepository.findById(id);
    }

    public List<Course> AllCourses(int id) {
        List<Course> courses = courseRepository.findByTeacherId(id);
        return courses;
    }

    public ResponseEntity modify(ModifyTeacherRequest teacherRequest)
    {
        if(teacherRepository.existsByNumber(teacherRequest.getNumber()))
        {
            Teacher teacher=teacherRepository.findByNumber(teacherRequest.getNumber()).get();
            teacher.setNumber(teacherRequest.getNumber());
            teacher.setGender(teacherRequest.getGender());
            teacher.setName(teacherRequest.getName());
            teacher.setCollege(teacherRequest.getCollege());
            teacherRepository.save(teacher);
            return ResponseEntity.ok("Success!");
        }
        else
        {
            return ResponseEntity
                    .badRequest()
                    .body("Error: No teacher match the number!");
        }
    }
}
