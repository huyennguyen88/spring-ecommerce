package com.example.springecommerce.form.users;

import com.example.springecommerce.entity.User;
import com.example.springecommerce.validation.EmailConstraint;
import com.example.springecommerce.validation.PasswordConfirmConstraint;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
@PasswordConfirmConstraint
public class UserRegisterForm {

    @NotBlank(message = "Full name cannot be blank")
    @Size(min=2, max=30, message = "Full name must be between 2 and 30 characters")
    private String fullname;

    @Pattern(regexp = "^(?=.{5,20}$)[a-zA-Z0-9._]+", message = "Username is 5 and 20 characters long a-z, A-Z, 0-9")
    private String username;

    @NotBlank(message = "Email cannot be blank")
    @EmailConstraint
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Minimum eight characters, at least one letter and one number:")
    private String password;

    @NotBlank(message = "Confirm password cannot be blank")
    private String confirmPassword;

}
