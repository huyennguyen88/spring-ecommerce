package com.example.springecommerce.service.impl;

import com.example.springecommerce.entity.Category;
import com.example.springecommerce.service.CategoryService;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

    @Override
    public Category findById(Serializable key) {
        return null;
    }

    @Override
    public Category saveOrUpdate(Category entity) {
        return null;
    }

    @Override
    public boolean delete(Category entity) {
        return false;
    }

}
