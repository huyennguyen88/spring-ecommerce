package com.example.springecommerce.dto;

import com.example.springecommerce.entity.User;

import javax.persistence.Column;
import java.util.Date;

public class UserDTO extends AbstractDTO<User> {
    private int id;
    private String fullname;
    private String username;
    private String email;
    private String avatar;
    private String phone;
    private String address;

    public UserDTO(User user) {
        this.id = user.getId();
        this.fullname = user.getFullname();
        this.username = user.getUsername();
        this.address = user.getAddress();
        this.avatar = user.getAvatar();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }

    public UserDTO() {

    }

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
