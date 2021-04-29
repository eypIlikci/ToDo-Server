package com.todo.util;


import com.todo.entity.User;
import com.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class UniqueUsernameForUpdateValidator implements ConstraintValidator<UniqueUsernameForUpdate,String>{
        @Autowired
        private UserRepository userRepository;

    @Override
    public boolean isValid(String username, ConstraintValidatorContext constraintValidatorContext) {
        User userAuth=(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (username.equals(userAuth.getUsername()) || userRepository.findByUsername(username)==null)return true;
        return false;
    }
    }