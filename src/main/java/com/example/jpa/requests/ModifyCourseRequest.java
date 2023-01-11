package com.example.jpa.requests;

public class ModifyCourseRequest {
    String username;
    String name;
    String number;
    int credit;

    public ModifyCourseRequest(String username, String name, String number, int credit) {
        this.username = username;
        this.name = name;
        this.number = number;
        this.credit = credit;
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

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
