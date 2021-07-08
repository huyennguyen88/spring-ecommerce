package com.example.springecommerce.form.users;

import com.example.springecommerce.entity.User;
import com.example.springecommerce.validation.PasswordConfirmConstraint;

import javax.validation.constraints.*;
@PasswordConfirmConstraint
public class UserRegisterForm {

    @NotBlank(message = "Full name cannot be blank")
    @Size(min=2, max=30, message = "Full name must be between 2 and 30 characters")
    private String fullname;

    @Pattern(regexp = "^(?=.{5,20}$)[a-zA-Z0-9._]+", message = "Username is 5 and 20 characters long a-z, A-Z, 0-9")
    private String username;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Minimum eight characters, at least one letter and one number:")
    private String password;

    @NotBlank(message = "Confirm password cannot be blank")
    private String confirmPassword;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public User toUserEntity() {
        User user = new User();
        user.setUsername(this.getUsername());
        user.setFullname(this.getFullname());
        user.setEmail(this.getEmail());
        user.setPassword(this.getPassword());
        return user;
    }
}
