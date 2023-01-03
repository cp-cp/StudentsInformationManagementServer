package com.example.jpa.controller;

import com.example.jpa.bean.Course;
import com.example.jpa.bean.Teacher;
import com.example.jpa.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController 
{
    @Autowired
    TeacherService teacherService;

    @GetMapping("/init")
    String init() {return teacherService.init();}

    @GetMapping("/all")
    List<Teacher> findall()
    {
        return teacherService.findAll();
    }
    //按照Id查询,一种是Post方法一种是Get方法
    @PostMapping("/findById")
    Optional<Teacher> findById(@RequestBody int id)
    {
        return teacherService.findById(id);
    }
    @GetMapping("/getById/{id}")
    Optional<Teacher> getById(@PathVariable("id") int id)
    {
        return teacherService.getById(id);
    }

    @PostMapping("/findByIdAllCourses")
    List<Course> findByIdAllCourses(@RequestBody int id){return  teacherService.AllCourses(id);}

    @GetMapping("/getByIdAllCourses/{id}")
    List<String> getByIdAllCourses(@PathVariable("id") int id)
    {
        List<Course> courses=teacherService.AllCourses(id);
        List<String> list = new ArrayList<>();
        for(Course course:courses)
        {
            list.add(course.getName());
        }
        return list;
    }




    //增添
    @PostMapping("/add")
    String add(  @RequestBody Teacher Teacher)
    {
        return teacherService.add(Teacher);
    }
    //删除
    @DeleteMapping("/deleteById/{id}")
    String delete(@PathVariable int id)
    {
        return teacherService.delete(id);
    }
}
