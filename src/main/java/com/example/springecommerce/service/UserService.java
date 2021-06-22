package com.example.springecommerce.service;

import com.example.springecommerce.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService extends BaseService<Integer, User> {
    List<User> findAll();
    User findByUsername(String username);
}
