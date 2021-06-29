package com.example.springecommerce.service;

import com.example.springecommerce.dto.UserDTO;
import com.example.springecommerce.entity.User;
import com.example.springecommerce.form.UserForm;
import org.hibernate.annotations.Any;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findById(int id);
    List<UserDTO> findAll(Pageable pageable);
    int getSize();
    boolean delete(int id);
    ResponseEntity<UserDTO> update(int user_id, UserForm.Update userForm);
}
