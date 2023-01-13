package com.example.jpa.service;

import com.example.jpa.bean.Score;
import com.example.jpa.dao.CourseRepository;
import com.example.jpa.dao.ScoreRepository;
import com.example.jpa.dao.StudentRepository;
import com.example.jpa.request.InsertScoreRequest;
import com.example.jpa.request.ModifyScoreRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class ScoreService {

    @Autowired
    ScoreRepository scoreRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;

    public List<Score> findByStudentNumber(String studentNumber) {
        return scoreRepository.findByStudentNumber(studentNumber);
    }

    public List<Score> findByCourseNumber(String courseNumber) {
        return scoreRepository.findByCourseNumber(courseNumber);
    }

    public String init()
    {
        Random random=new Random();
        for (int i = 1; i <=10; i++)
        {
            InsertScoreRequest insertScoreRequest=new InsertScoreRequest();
            insertScoreRequest.setScore((random.nextInt(100)+1));
            insertScoreRequest.setCourseNumber(courseRepository.findById(random.nextInt(10)+1).get().getNumber()+"");
            insertScoreRequest.setStudentNumber(studentRepository.findById(random.nextInt(10)+1).get().getNumber()+"");
            add(insertScoreRequest);
        }
        return "Success!";
    }

    public List<Score> all() {
        return scoreRepository.findAll();
    }

    public ResponseEntity add(InsertScoreRequest insertScoreRequest) {
        Score score=new Score();
        if(!scoreRepository.findByStudentNumberAndCourseNumber(insertScoreRequest.getStudentNumber(),insertScoreRequest.getCourseNumber()).isPresent())
        {
            if (studentRepository.existsByNumber(insertScoreRequest.getStudentNumber()))
            {
                if (courseRepository.existsByNumber(insertScoreRequest.getCourseNumber()))
                {
                    score.setStudent(studentRepository.findByNumber(insertScoreRequest.getStudentNumber()).get());
                    score.setCourse(courseRepository.findByNumber(insertScoreRequest.getCourseNumber()).get());
                    score.setScore(insertScoreRequest.getScore());
                    scoreRepository.save(score);
                    return ResponseEntity.ok("Success!");

                }
                else
                {
                    return ResponseEntity.badRequest().body("The course does not exist!");
                }
            }
            else
            {
                return ResponseEntity.badRequest().body("The student does not exist!");
            }
        }else
        {
            return ResponseEntity.badRequest().body("The score already exists!");
        }
    }

    public Optional<Score> findByStudentNumberAndCourseNumber(String studentNumber, String courseNumber) {
        return scoreRepository.findByStudentNumberAndCourseNumber(studentNumber,courseNumber);
    }

    public ResponseEntity modify(ModifyScoreRequest modifyScoreRequest) {
        Optional<Score> score=scoreRepository.findByStudentNumberAndCourseNumber(modifyScoreRequest.getStudentNumber(),modifyScoreRequest.getCourseNumber());
        if(score.isPresent())
        {
            score.get().setScore(modifyScoreRequest.getScore());
            scoreRepository.save(score.get());
            return ResponseEntity.ok("Success!");
//            if (studentRepository.existsByNumber(modifyScoreRequest.getStudentNumber()))
//            {
//                if (courseRepository.existsByNumber(modifyScoreRequest.getCourseNumber()))
//                {
//                    score.setStudent(studentRepository.findByNumber(modifyScoreRequest.getStudentNumber()).get());
//                    score.setCourse(courseRepository.findByNumber(modifyScoreRequest.getCourseNumber()).get());
//                }
//                else
//                {
//                    return ResponseEntity.badRequest().body("The course does not exist!");
//                }
//            }
//            else
//            {
//                return ResponseEntity.badRequest().body("The student does not exist!");
//            }
        }else
        {
            return ResponseEntity.badRequest().body("The score does not exist!");
        }

    }

    public List<Score> findByTeacherNumber(String number) {
        Sort sort=Sort.by("CourseNumber");
        return scoreRepository.findByCourseTeacherNumber(number,null);
    }

    public ResponseEntity deleteByStudentNumberAndCourseNumber(String studentNumber, String courseNumber)
    {
        Optional<Score> score=scoreRepository.findByStudentNumberAndCourseNumber(studentNumber,courseNumber);
        if(score.isPresent())
        {
            scoreRepository.deleteByStudentNumberAndCourseNumber(studentNumber, courseNumber);
            return ResponseEntity.ok("Success!");
        }
        else
        {
            return ResponseEntity.badRequest().body("No score matches student and course!");
        }
    }

    public ResponseEntity deleteByStudentNumber(String studentNumber) {
        if(studentRepository.existsByNumber(studentNumber))
        {
            Long len=scoreRepository.deleteByStudentNumber(studentNumber);
            if(len>1)
                return ResponseEntity.ok("delete "+len+" scores");
            else
                return ResponseEntity.ok("delete "+len+" score");
        }
        else
        {
            return ResponseEntity.badRequest().body("Student does not exist!");
        }
    }

    public ResponseEntity deleteByCourseNumber(String courseNumber) {
        if(courseRepository.existsByNumber(courseNumber))
        {
            Long len=courseRepository.deleteByNumber(courseNumber);
            if(len>1)
                return ResponseEntity.ok("delete "+len+" scores");
            else
                return ResponseEntity.ok("delete "+len+" score");
        }
        else
        {
            return ResponseEntity.badRequest().body("Course does not exist!");
        }
    }
}
