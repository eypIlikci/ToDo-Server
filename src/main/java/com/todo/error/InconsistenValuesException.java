package com.todo.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InconsistenValuesException extends RuntimeException{
    public InconsistenValuesException(){

    }
    public  InconsistenValuesException(String message){
        super(message);
    }
}
