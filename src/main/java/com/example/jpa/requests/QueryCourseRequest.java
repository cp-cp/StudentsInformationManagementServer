package com.example.jpa.requests;

public class QueryCourseRequest {
    String username;

    public QueryCourseRequest(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
