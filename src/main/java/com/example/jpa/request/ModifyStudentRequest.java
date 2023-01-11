package com.example.jpa.request;

public class ModifyStudentRequest {//给用户名为username的用户修改编号为id,修改后信息如下的学生
    String username;
    String number;
    String name;
    String gender;
    String college;
    int score;

    public ModifyStudentRequest(String username, String number, String name, String gender, String college, int score) {
        this.username = username;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.college = college;
        this.score = score;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
