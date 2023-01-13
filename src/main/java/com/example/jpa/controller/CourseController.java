package com.example.jpa.controller;

import com.example.jpa.bean.Course;
import com.example.jpa.bean.Student;
import com.example.jpa.dao.CourseRepository;
import com.example.jpa.dao.TeacherRepository;
import com.example.jpa.request.InsertStudentRequest;
import com.example.jpa.request.ModifyUserRequest;
import com.example.jpa.requests.InsertCourseRequest;
import com.example.jpa.requests.ModifyCourseRequest;
import com.example.jpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private static final int PAGE_SIZE = 4;
    @Autowired
    CourseService courseService;
    @Autowired
    private TeacherRepository teacherRepository;
    private CourseRepository courseRepository;

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

    @DeleteMapping("/deleteByTeacherNumber/{number}")
    String deleteByTeacherNumber(@PathVariable String number) {
        return courseService.deleteByTeacherNumber(number);
    }

    @GetMapping(value = "course/page/{pageNo}")
    public Page<Course> getStudentWithPage(@PathVariable int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, PAGE_SIZE); // PAGE_SIZE 控制每一页最多的学生数量
        return courseRepository.findAll(pageable);
    }

    @DeleteMapping("/deleteByNumber/{id}")
    ResponseEntity delete(@PathVariable String number) {
        return courseService.delete(number);
    }

    @PostMapping("/add")
    ResponseEntity add(@RequestBody InsertCourseRequest course) {
        return courseService.add(course);
    }

    @PostMapping("/modify")
    ResponseEntity modify(@RequestBody ModifyCourseRequest courseRequest)  {
        return courseService.modify(courseRequest);
    }
}
