package com.example.springecommerce.form.users;

import com.example.springecommerce.entity.User;

import javax.validation.constraints.*;

public class UserRegisterForm {

    @NotBlank(message = "Full name cannot be blank")
    @Size(min=2, max=30, message = "Full name must be between 2 and 30 characters")
    private String fullname;

    @NotBlank(message = "Username cannot be blank")
    @Size(min=2, max=20, message = "User name must be between 2 and 20 characters")
    private String username;

    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Please enter confirm password")
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
        user.setUsername(this.getUsername());
        user.setFullname(this.getFullname());
        return user;
    }
}
