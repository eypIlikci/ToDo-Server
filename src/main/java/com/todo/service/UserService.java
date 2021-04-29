package com.todo.service;

import com.todo.dto.CreateUser;
import com.todo.dto.UpdateUserDto;
import com.todo.dto.UserDto;
import com.todo.entity.User;

public interface UserService {
    UserDto save(CreateUser user);
    UserDto update(UpdateUserDto user);
}
