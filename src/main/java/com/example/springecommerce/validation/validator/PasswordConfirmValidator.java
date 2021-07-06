package com.example.springecommerce.validation.validator;

import com.example.springecommerce.form.users.UserRegisterForm;
import com.example.springecommerce.validation.PasswordConfirmConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConfirmValidator implements ConstraintValidator<PasswordConfirmConstraint, Object> {
    @Override
    public void initialize(PasswordConfirmConstraint constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object userForm, ConstraintValidatorContext constraintValidatorContext) {
        UserRegisterForm user = (UserRegisterForm) userForm;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
