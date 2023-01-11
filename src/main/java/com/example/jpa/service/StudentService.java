package com.example.jpa.service;

import com.example.jpa.bean.Student;
import com.example.jpa.dao.StudentRepository;
import com.example.jpa.request.InsertStudentRequest;
import com.example.jpa.request.ModifyStudentRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String init() {
        String[] name = {"John", "Jane", "Mark", "Mia",
                "David", "Emily", "Michael", "Sarah", "Peter", "Elizabeth"};
        String[] college = {"Accountant", "Architect", "Engineer", "Lawyer", "Doctor", "Dentist", "Veterinarian", "Psychologist", "Developer", "Designer"};
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            Student student = new Student();
            student.setName(name[i]);
            student.setCollege(college[i]);
            if(random.nextInt(2)==1)student.setGender("男");
            else student.setGender("女");
            Integer number=random.nextInt(10000) + 0120210000;
            student.setNumber(number.toString());
            studentRepository.save(student);
        }
        return "initialize students successfully!";
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> getById(int id) {
        return studentRepository.findById(id);
    }

    public String add(InsertStudentRequest student) {
        if (studentRepository.existsByNumber(student.getNumber()))
            return "It has been repeated.";
        else {
            Student student1=new Student();
            student1.setGender(student.getGender());
            student1.setCollege(student.getCollege());
            student1.setNumber(student.getNumber());
            student1.setName(student.getName());
            student1.setScore(student1.getScore());
            studentRepository.save(student1);
            return "Add " + student + " successfully!";
        }
    }

    public String delete(int id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "Delete " + id + " successfully!";
        } else {
            return "Unable to find this id.";
        }
    }

    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    public String modify(ModifyStudentRequest studentRequest)
    {
        Student student=studentRepository.findByNumber(studentRequest.getNumber()).get();
        student.setScore(studentRequest.getScore());
        student.setGender(studentRequest.getGender());
        student.setCollege(studentRequest.getCollege());
        student.setNumber(studentRequest.getNumber());
        student.setName(studentRequest.getName());
        studentRepository.save(student);
        return "Success";
    }
}
