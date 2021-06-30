package com.example.springecommerce.repository;

import com.example.springecommerce.entity.Category;
import com.example.springecommerce.repository.custom.CategoryRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>, CategoryRepositoryCustom {

//    @Query("SELECT c FROM Category c WHERE c.parent is null")
//    List<Category> getRoots();
}
