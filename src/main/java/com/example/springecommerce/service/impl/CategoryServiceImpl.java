package com.example.springecommerce.service.impl;

import com.example.springecommerce.entity.Category;
import com.example.springecommerce.service.CategoryService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

    private static final Logger logger = Logger.getLogger(CategoryServiceImpl.class);

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
