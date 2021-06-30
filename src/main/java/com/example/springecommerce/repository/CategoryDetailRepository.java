package com.example.springecommerce.repository;

import com.example.springecommerce.entity.Category;
import com.example.springecommerce.entity.CategoryDetail;
import com.example.springecommerce.repository.custom.CategoryDetailRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryDetailRepository extends JpaRepository<CategoryDetail, Integer>, CategoryDetailRepositoryCustom {
    List<CategoryDetail> findByParentIsNull();
}
