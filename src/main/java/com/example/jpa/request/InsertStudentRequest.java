package com.example.jpa.request;

public class InsertStudentRequest {//给用户名为username的用户插入学号为number,学生信息如下的学生
    String username;
    String name;
    String number;
    String college;
    String gender;
    int score;

    public InsertStudentRequest(String username, String name, String number, String college, String gender,int score) {
        this.username = username;
        this.name = name;
        this.number = number;
        this.college = college;
        this.gender = gender;
        this.score = score;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
