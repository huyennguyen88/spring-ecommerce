package com.example.springecommerce.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserResDto {
    private int id;
    private String username;
    private String fullname;
    private String email;
    private String avatar;
    private String phone;
    private String address;
    private LocalDateTime createdDate;
    private String createDateString;
}
