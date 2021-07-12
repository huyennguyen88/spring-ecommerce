package com.example.springecommerce.dto.response;

import com.example.springecommerce.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseResDto {
    private int id;
    private String username;
    private String fullname;
    private String email;

    public UserResponseResDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.fullname = user.getFullname();
        this.email = user.getEmail();
    }
}
