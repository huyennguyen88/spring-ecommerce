package com.example.springecommerce.dto;

import com.example.springecommerce.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO extends AbstractDTO<User> {
    private int id;
    private String fullname;
    private String username;
    private String email;
    private String avatar;
    private String phone;

    public UserDTO(User user) {
        this.id = user.getId();
        this.fullname = user.getFullname();
        this.username = user.getUsername();
        this.avatar = user.getAvatar();
        this.email = user.getEmail();
        this.phone = user.getPhone();
    }

}
