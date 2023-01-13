package com.example.jpa.request;

import javax.validation.constraints.Max;

public class InsertScoreRequest
{
    int score;
    String studentNumber;
    String courseNumber;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    @Override
    public String toString() {
        return "InsertScoreRequest{" +
                "score=" + score +
                ", studentNumber='" + studentNumber + '\'' +
                ", courseNumber='" + courseNumber + '\'' +
                '}';
    }
}
