package com.example.springecommerce.validation;

import com.example.springecommerce.form.users.UserRegisterForm;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidation implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return UserRegisterForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRegisterForm form = (UserRegisterForm) target;

        if (StringUtils.isBlank(form.getUsername())) {
            errors.rejectValue("username", "NotEmpty");
        }

        if (StringUtils.isBlank(form.getEmail())) {
            errors.rejectValue("email", "NotEmpty");
        } else if (new EmailValidator().isValid(form.getEmail(), null) == false) {
            errors.rejectValue("email", "Error.Email.Format");
        }

        if (StringUtils.isBlank(form.getPassword())) {
            errors.rejectValue("password", "NotEmpty");
        } else if (form.getPassword().length() < 5) {
            errors.rejectValue("password", "Error.Pass.Size");
        } else if (!form.getPassword().equals(form.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "Error.Pass.Incorrect");
        }

    }

}
