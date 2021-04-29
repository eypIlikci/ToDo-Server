package com.todo.error;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private int status;
    private String message;
    private long timestamp=new Date().getTime();
    private Map<String,String> validationErros;
    public ApiError(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public Map<String, String> getValidationErros() {
        if (this.validationErros==null)this.validationErros=new HashMap<>();
        return validationErros;
    }

    public void setValidationErros(Map<String, String> validationErros) {
        this.validationErros = validationErros;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
