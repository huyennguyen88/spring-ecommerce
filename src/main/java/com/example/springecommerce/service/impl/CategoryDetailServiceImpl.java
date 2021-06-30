package com.example.springecommerce.service.impl;

import com.example.springecommerce.dto.response.CategoryResDto;
import com.example.springecommerce.entity.Category;
import com.example.springecommerce.entity.CategoryDetail;
import com.example.springecommerce.service.CategoryDetailService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CategoryDetailServiceImpl extends BaseServiceImpl implements CategoryDetailService {
    private static final Logger logger = Logger.getLogger(CategoryDetailServiceImpl.class);

    @Override
    public List<CategoryResDto> getRoots() {
        List<CategoryResDto> categoryResDtos = new ArrayList<>();
        try {
            List<CategoryDetail> categoryDetails = getCategoryDetailRepository().findByParentIsNull();
            for (CategoryDetail categoryDetail : categoryDetails) {
                categoryResDtos.add(new CategoryResDto(categoryDetail));
            }
            return categoryResDtos;

        } catch (Exception e) {
            logger.error("Error get roots ", e);
            return categoryResDtos;
        }
    }
}
