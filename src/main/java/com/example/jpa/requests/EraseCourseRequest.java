package com.example.jpa.requests;

public class EraseCourseRequest {
    String username;
    String number;

    public EraseCourseRequest(String username, String number) {
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
