package com.example.jpa.controller;

import com.example.jpa.bean.Course;
import com.example.jpa.dao.TeacherRepository;
import com.example.jpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    CourseService courseService;
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/init")
    String init() {
        return courseService.init();
    }

    @GetMapping("/all")
    List<Course> findAll() { return courseService.findAll(); }

    @GetMapping("/getById")
    Optional<Course> findById(@RequestBody int id) {
        return courseService.getById(id);
    }

    @PostMapping("/findByTeacherId")
    List<Course> findByTeacherId(@RequestBody int teacherId) {
        return courseService.findByTeacherId(teacherId);
    }

    @PostMapping("/findByCredit")
    List<Course> findByCredit(@RequestBody int credit) {
        return courseService.findByCredit(credit);
    }

    @DeleteMapping("/deleteByTeacherId/{id}")
    String deleteByTeacherId(@PathVariable int id) {
        return courseService.deleteByTeacherId(id);
    }

}
