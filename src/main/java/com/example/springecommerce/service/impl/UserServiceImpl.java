package com.example.springecommerce.service.impl;

import com.example.springecommerce.entity.User;
import com.example.springecommerce.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Override
    public User getById(int key) {
        try {
            return getUserRepository().getById(key);
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public User saveOrUpdate(User entity) {
        return null;
    }

    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public List<User> findAll() {
        try {
            return getUserRepository().findAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

}
