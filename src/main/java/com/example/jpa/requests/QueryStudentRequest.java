package com.example.jpa.requests;

public class QueryStudentRequest {//查询用户名为username的用户的所有学生
    String username;

    public QueryStudentRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
