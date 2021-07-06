package com.example.springecommerce.validation;

import com.example.springecommerce.validation.validator.PasswordConfirmValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordConfirmValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PasswordConfirmConstraint {
    String message() default "Passwords are not the same";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
