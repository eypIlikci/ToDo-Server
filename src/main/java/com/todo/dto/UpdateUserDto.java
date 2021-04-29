package com.todo.dto;

import com.todo.entity.User;
import com.todo.util.UniqueUsernameForUpdate;

import javax.validation.constraints.NotNull;

public class UpdateUserDto {
    @NotNull
    private Long id;
    @NotNull
    @UniqueUsernameForUpdate
    private String username;
    @NotNull
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
        user.setId(this.id);
        user.setUsername(this.username);
        user.setPassword(this.password);
        return user;
    }
}
