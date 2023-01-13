package com.example.jpa.request;

public class ModifyUserRequest {
    String username;
    String password;
    String email;

    public ModifyUserRequest(String username, String password, String email) {
        this.email = email;
        this.password = password;
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getEmail() {
        return this.email;
    }
}
