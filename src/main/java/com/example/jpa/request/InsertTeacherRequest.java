package com.example.jpa.request;

public class InsertTeacherRequest {
    String username;
    String name;
    String number;
    String college;
    String gender;

    public InsertTeacherRequest(String username, String name, String number, String course, String gender) {
        this.username = username;
        this.name = name;
        this.number = number;
        this.college = course;
        this.gender = gender;
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

    public void setCollege(String course) {
        this.college = course;
    }

}
