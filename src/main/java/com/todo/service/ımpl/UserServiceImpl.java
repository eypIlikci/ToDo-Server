package com.todo.service.ımpl;

import com.todo.dto.CreateUser;
import com.todo.dto.UpdateUserDto;
import com.todo.dto.UserDto;
import com.todo.entity.User;
import com.todo.error.InconsistenValuesException;
import com.todo.repository.UserRepository;
import com.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public UserServiceImpl() {
        this.passwordEncoder=new BCryptPasswordEncoder();
    }

    @Override
    public UserDto save(CreateUser user) {
        return UserDto.toUserDto(userRepository.save(user.toUser()));
    }

    @Override
    public UserDto update(UpdateUserDto user) {

        User userAuth=(User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        if (userAuth.getId()!=user.getId())throw new InconsistenValuesException("User id is wrong. Repeat login");
        User upUser=user.toUser();
        return UserDto.toUserDto(userRepository.save(upUser));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }
}
