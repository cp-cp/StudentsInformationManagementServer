package com.example.jpa.service;

import com.example.jpa.bean.Course;
import com.example.jpa.bean.Teacher;
import com.example.jpa.dao.CourseRepository;
import com.example.jpa.dao.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CourseService {
//    @Autowired
//    CourseRepository courseRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    private CourseRepository courseRepository;

    public String init()
    {
//         return "yeas";
        String[] name={"Math", "Physics", "Biology", "Chemistry", "English", "Geography", "History", "Art", "Music", "Physical Education"};
        for(int i=0;i<10;i++)
        {
            Random random = new Random();
            Course course=new Course();
            course.setName(name[i]);
            course.setCredit(random.nextInt(10));
            course.setTeacher(teacherRepository.getById(random.nextInt(9)+1));
            courseRepository.save(course);
        }
        return"success";
    }

    public Optional<Course> findById(int id)
    {
        return courseRepository.findById(id);
    }

    public List<Course> findByTeacherId(int teacherId) {
        return courseRepository.findByTeacherId(teacherId);
    }

    public List<Course> findByCredit(int credit)
    {
        return courseRepository.findByCredit(credit);
    }

    public String deleteByTeacherId(int id)
    {
        return "Success"+courseRepository.deleteByTeacherId(id);
    }
}
