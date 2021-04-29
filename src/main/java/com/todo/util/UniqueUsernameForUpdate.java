package com.todo.util;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.ANNOTATION_TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameForUpdateValidator.class)
@Documented
public @interface UniqueUsernameForUpdate {
    String message() default "Username must be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
