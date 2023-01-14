package com.example.jpa.service;

import com.example.jpa.bean.Course;
import com.example.jpa.bean.Teacher;
import com.example.jpa.dao.CourseRepository;
import com.example.jpa.dao.TeacherRepository;
import com.example.jpa.request.InsertCourseRequest;
import com.example.jpa.request.ModifyCourseRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CourseService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;

    public String init() {
        String[] name = {"Math", "Physics", "Biology",
                "Chemistry", "English", "Geography", "History", "Art", "Music", "Physical Education"};
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            Course course = new Course();
            course.setName(name[i]);
            course.setCredit(random.nextInt(10));
            Integer number = random.nextInt(10000) + 0320210000;
            course.setNumber(number.toString());
            course.setTeacher(teacherRepository.getById(random.nextInt(9) + 1));
            courseRepository.save(course);
        }
        return "initialize courses successfully!";
    }

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> getById(int id) {
        return courseRepository.findById(id);
    }

    public List<Course> findByTeacherNumber(String teacherNumber) {
        return courseRepository.findByTeacherNumber(teacherNumber);
    }

    public List<Course> findByCredit(int credit) {
        return courseRepository.findByCredit(credit);
    }

    public String deleteByTeacherNumber(String number) {
        return "Delete " + courseRepository.deleteByTeacherNumber(number) + " successfully!";
    }

    public ResponseEntity add(InsertCourseRequest course) {
        if (courseRepository.existsByNumber(course.getNumber())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: The course has been existed!");
        } else {
            Course course1 = new Course();
            course1.setName(course.getName());
            course1.setCredit(course.getCredit());
            course1.setNumber(course.getNumber());
            Optional<Teacher> teacher=teacherRepository.findByNumber(course.getTeacherNumber());
            if(teacher.isPresent())
            {
                course1.setTeacher(teacher.get());
                return ResponseEntity.ok("Success!");
            }
            else
            {
                return ResponseEntity.badRequest().body("Teacher does not exists!");
            }
        }
    }

    public ResponseEntity delete(String number) {
        if (courseRepository.existsByNumber(number)) {
            courseRepository.deleteByNumber(number);
            //courseRepository.deleteByTeacherNumber(number);
            return ResponseEntity.ok().body("Delete " + number + " successfully!");
        } else {
            return ResponseEntity
                    .badRequest()
                    .body("Error: No match!");
        }
    }

    public ResponseEntity modify(ModifyCourseRequest courseRequest) {
        if (courseRepository.existsByNumber(courseRequest.getNumber())) {
            Course course = courseRepository.findByNumber(courseRequest.getNumber()).get();
            course.setCredit(courseRequest.getCredit());
            course.setName(courseRequest.getName());
            course.setNumber(courseRequest.getNumber());
            Optional<Teacher> teacher=teacherRepository.findByNumber(courseRequest.getTeacherNumber());
            if (teacher.isPresent())
            {
                course.setTeacher(teacher.get());
                courseRepository.save(course);
                return ResponseEntity.ok("Success");
            }
            else
            {
                return ResponseEntity
                        .badRequest()
                        .body("Error:  the teacher does not exists!");
            }
        } else {
            return ResponseEntity
                    .badRequest()
                    .body("Error:  No student match the username");
        }
    }
}
