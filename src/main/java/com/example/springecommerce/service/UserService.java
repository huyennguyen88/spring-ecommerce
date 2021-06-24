package com.example.springecommerce.service;

import com.example.springecommerce.dto.UserDTO;
import com.example.springecommerce.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(int id);
    List<UserDTO> findAll(Pageable pageable);
    int getSize();
    boolean delete(int id);
}
