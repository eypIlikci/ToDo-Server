package com.todo.api;


import com.todo.dto.CreateUser;
import com.todo.dto.UpdateUserDto;
import com.todo.dto.UserDto;
import com.todo.entity.User;
import com.todo.service.UserService;
import com.todo.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "user")
    public ResponseEntity<?> register(@Valid @RequestBody CreateUser user){
       return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PostMapping(value = "auth")
    public ResponseEntity<?> login(@CurrentUser User user){
        return ResponseEntity.ok(UserDto.toUserDto(user));
    }

    @PutMapping(value = "user")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateUserDto userDto){
        return ResponseEntity.ok(userService.update(userDto));
    }

}
