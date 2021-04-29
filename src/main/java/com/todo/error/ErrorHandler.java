package com.todo.error;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.List;
import java.util.Map;

@RestController
public class ErrorHandler implements ErrorController {
    @Autowired
    private ErrorAttributes errorAttributes;
    @RequestMapping("/error")
    ApiError handleError(WebRequest webRequest){
        Map<String,Object> attributes=this.errorAttributes.getErrorAttributes(webRequest, ErrorAttributeOptions.of(ErrorAttributeOptions.Include.MESSAGE, ErrorAttributeOptions.Include.BINDING_ERRORS));
        ApiError error=new ApiError(
                (Integer)attributes.get("status"),
                (String)attributes.get("message")

        );
        if (attributes.containsKey("errors")){
            List<FieldError> fieldErrors= (List<FieldError>) attributes.get("errors");
            for (FieldError fieldError:fieldErrors) {
                error.getValidationErros().put(fieldError.getField(),fieldError.getDefaultMessage());
            }
        }

        return error;

    }

    @Override
    public String getErrorPath() {
        return "/error";
    }


    @ExceptionHandler({InconsistenValuesException.class})
    public void handleException(){

    }
}
