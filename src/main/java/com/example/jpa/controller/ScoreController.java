package com.example.jpa.controller;

import com.example.jpa.bean.Score;
import com.example.jpa.request.InsertScoreRequest;
import com.example.jpa.request.ModifyScoreRequest;
import com.example.jpa.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @GetMapping("/init")
    String init() {return scoreService.init();}
    @GetMapping("/all")
    List<Score> all(){return scoreService.all();}
    @GetMapping("/findByStudentNumber/{studentNumber}")
    List<Score> findByStudentNumber(@PathVariable String studentNumber){return scoreService.findByStudentNumber(studentNumber);}
    @GetMapping("/findByCourseNumber/{courseNumber}")
    List<Score> findByCourseNumber(@PathVariable String courseNumber){return scoreService.findByCourseNumber(courseNumber);}
    @GetMapping("/findByStudentNumberAndCourseNumber/{studentNumber}&{courseNumber}")
    Score findByStudentNumberAndCourseNumber(@PathVariable String studentNumber,@PathVariable String courseNumber)
    {
        Optional<Score> score=scoreService.findByStudentNumberAndCourseNumber(studentNumber,courseNumber);
        if (score.isPresent())
        {
            return score.get();
        }
        else
        {
            return null;
        }
    }
    @PostMapping("/add")
    ResponseEntity add(@RequestBody InsertScoreRequest insertScoreRequest){return scoreService.add(insertScoreRequest);}

    @PostMapping("/modify")
    ResponseEntity modify(@RequestBody ModifyScoreRequest modifyScoreRequest){return scoreService.modify(modifyScoreRequest);}

    @GetMapping("/findByTeacherNumber/{number}")
    List<Score> findByTeacherNumber(@PathVariable String number){return  scoreService.findByTeacherNumber(number);}

    @DeleteMapping("/deleteByStudentNumberAndCourseNumber/{studentNumber}&{courseNumber}")
    ResponseEntity deleteByStudentNumberAndCourseNumber(@PathVariable String studentNumber,@PathVariable String courseNumber)
    {return scoreService.deleteByStudentNumberAndCourseNumber(studentNumber,courseNumber);}

    @DeleteMapping("/deleteByStudentNumber/{studentNumber}")
    ResponseEntity deleteByStudentNumber(@PathVariable String studentNumber){return scoreService.deleteByStudentNumber(studentNumber);}

    @DeleteMapping("/deleteByCourseNumber/{courseNumber}")
    ResponseEntity deleteByCourseNumber(@PathVariable String courseNumber){return  scoreService.deleteByCourseNumber(courseNumber);}
}
