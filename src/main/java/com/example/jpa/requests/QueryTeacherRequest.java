package com.example.jpa.requests;

public class QueryTeacherRequest {//查询用户名为username的用户的所有老师
    String username;

    public QueryTeacherRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
