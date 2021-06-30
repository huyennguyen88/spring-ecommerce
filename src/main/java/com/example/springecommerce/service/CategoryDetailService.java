package com.example.springecommerce.service;

import com.example.springecommerce.dto.response.CategoryResDto;
import com.example.springecommerce.entity.Category;
import com.example.springecommerce.entity.CategoryDetail;

import java.util.List;

public interface CategoryDetailService {
    List<CategoryResDto> getRoots();
}
