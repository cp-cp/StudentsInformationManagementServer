package com.example.jpa.dao;

import com.example.jpa.bean.Score;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Repository
@Transactional
public interface ScoreRepository extends JpaRepository<Score,Integer>
{
    List<Score> findByCourseNumber(String CourseNumber);
//
    List<Score> findByStudentNumber(String studentNumber);

    Optional<Score> findByStudentNumberAndCourseNumber(String studentNumber,String courseNumber);

    List<Score> findByCourseTeacherNumber(String number,Sort sort);
    Long deleteByStudentNumberAndCourseNumber(String studentNumber, String courseNumber);

    Long deleteByCourseTeacherNumber(String number);

    Long deleteByStudentNumber(String studentNumber);
    Long deleteByCourseNumber(String number);
}
