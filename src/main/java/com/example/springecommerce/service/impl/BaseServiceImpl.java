package com.example.springecommerce.service.impl;

import com.example.springecommerce.repository.ProductRepository;
import com.example.springecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseServiceImpl {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ProductRepository getProductRepository() {
        return productRepository;
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

}
