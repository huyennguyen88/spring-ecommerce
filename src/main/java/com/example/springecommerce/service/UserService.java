package com.example.springecommerce.service;

import com.example.springecommerce.dto.UserDTO;
import com.example.springecommerce.dto.response.UserResDto;
import com.example.springecommerce.exception.AlreadyExistException;
import com.example.springecommerce.exception.TransactionInternalException;
import com.example.springecommerce.form.users.UserRegisterForm;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserResDto findById(int id);
    List<UserDTO> findAll(Pageable pageable);
    int getSize();
    boolean delete(int id);
    UserResDto create(UserRegisterForm userRegisterForm) throws AlreadyExistException, TransactionInternalException;
}
