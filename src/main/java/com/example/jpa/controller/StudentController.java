package com.example.jpa.controller;


import com.example.jpa.dao.StudentRepository;
import com.example.jpa.request.InsertStudentRequest;
import com.example.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.jpa.bean.Student;
import com.example.jpa.request.ModifyStudentRequest;

import java.util.List;
import java.util.Optional;


@RestController//控制返回的格式，写入Http响应头
@RequestMapping("/students")
public class StudentController {
    private static final int PAGE_SIZE = 4;
    @Autowired
    StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/init")
    String init() {
        return studentService.init();
    }

    @GetMapping("/all")
    List<Student> findAll() {
        return studentService.findAll();
    }

    //按照Id查询,一种是Post方法一种是Get方法
    @PostMapping("/findById")
    Optional<Student> findById(@RequestBody int id) {
        return studentService.findById(id);
    }

    @GetMapping("/getById/{id}")
    Optional<Student> getById(@PathVariable("id") int id) {
        return studentService.getById(id);
    }
    @GetMapping("/findByNumber/{number}")
    Optional<Student> findByNumber(@PathVariable String number){return studentService.findByNumber(number);}
    //增添
    @PostMapping("/add")
    ResponseEntity add(@RequestBody InsertStudentRequest student) {
        return studentService.add(student);
    }

    //删除
    @DeleteMapping("/deleteByNumber/{number}")
    ResponseEntity delete(@PathVariable String number) {
        return studentService.delete(number);
    }

    @GetMapping(value = "student/page/{pageNo}")
    public Page<Student> getStudentWithPage(@PathVariable int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, PAGE_SIZE); // PAGE_SIZE 控制每一页最多的学生数量
        return studentRepository.findAll(pageable);
    }
    @PostMapping("/modify")
    ResponseEntity modify(@RequestBody ModifyStudentRequest studentRequest)
    {
        return studentService.modify(studentRequest);
    }
}

