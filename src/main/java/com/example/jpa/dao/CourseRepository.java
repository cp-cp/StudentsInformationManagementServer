package com.example.jpa.dao;

import com.example.jpa.bean.Course;
import com.example.jpa.bean.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    Page<Course> findAll(Pageable pageable);
    @Query("select c from Course c where c.teacher.id = ?1")
    List<Course> findByTeacherId(int id);
    @Query("select c from Course c where c.credit = ?1")
    List<Course> findByCredit(int credit);

    @Query("select c from Course c where c.id = ?1")
    Optional<Course> findById(int id);
    long deleteByTeacherNumber(String id);

    boolean existsByNumber(String Number);
    long deleteByNumber(String number);
    Optional<Course> findByNumber(String number);

    List<Course> findByTeacherNumber(String teacherNumber);
}
