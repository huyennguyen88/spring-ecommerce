package com.example.springecommerce.service;

import com.example.springecommerce.dto.UserDTO;
import com.example.springecommerce.dto.response.UserResponseResDto;
import com.example.springecommerce.entity.User;
import com.example.springecommerce.form.users.UserRegisterForm;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(int id);
    List<UserDTO> findAll(Pageable pageable);
    int getSize();
    boolean delete(int id);
    UserResponseResDto create(User user);
    boolean isUsernameExist(String username);
    boolean isEmailExist(String email);
}
