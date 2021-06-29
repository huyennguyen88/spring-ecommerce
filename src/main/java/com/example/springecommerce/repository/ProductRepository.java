package com.example.springecommerce.repository;

import com.example.springecommerce.entity.Product;
import com.example.springecommerce.repository.custom.ProductRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> , ProductRepositoryCustom {
}
