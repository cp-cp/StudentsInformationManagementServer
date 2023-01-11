package com.example.jpa.request;

public class ModifyTeacherRequest {
    String username;
    String number;
    String name;
    String gender;
    String college;

    public ModifyTeacherRequest(String username, String number, String name, String gender, String college) {
        this.username = username;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.college = college;
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
}
