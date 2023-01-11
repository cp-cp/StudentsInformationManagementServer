package com.example.jpa.requests;

public class EraseTeacherRequest {//给用户名为username的用户删除学工号为number的老师
    String username;
    String number;

    public EraseTeacherRequest(String username, String number) {
        this.username = username;
        this.number = number;
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
}
