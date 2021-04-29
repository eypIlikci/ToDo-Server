package com.todo.dto;


import com.todo.entity.User;
import com.todo.util.UniqueUsername;

import javax.validation.constraints.*;

public class CreateUser {

    @Size(max = 10,min = 3)
    @UniqueUsername
    private String username;

    @Size(max = 10,min = 3)
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User toUser(){
        User user=new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setId(null);
        return user;

    }
}
