package com.example.springecommerce.validation;

import com.example.springecommerce.validation.validator.EmailValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD})
public @interface EmailConstraint {
    String message() default "Invalid email! Email should be abc@xyz, abc could be a-z A-Z 0-9 .+%-_ and xyz is 2-6 in length";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
