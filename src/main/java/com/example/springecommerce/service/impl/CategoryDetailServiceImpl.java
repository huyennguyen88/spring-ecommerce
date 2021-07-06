package com.example.springecommerce.service.impl;

import com.example.springecommerce.dto.response.CategoryResDto;
import com.example.springecommerce.entity.CategoryDetail;
import com.example.springecommerce.service.CategoryDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryDetailServiceImpl extends BaseServiceImpl implements CategoryDetailService {
    private static final Logger logger = LoggerFactory.getLogger(CategoryDetailServiceImpl.class);

    @Override
    public List<CategoryResDto> getRoots() {
        List<CategoryResDto> categoryResDtos = new ArrayList<>();
        try {
            List<CategoryDetail> categoryDetails = getCategoryDetailRepository().findByParentIsNull();
            for (CategoryDetail categoryDetail : categoryDetails) {
                categoryResDtos.add(new CategoryResDto(categoryDetail));
            }
            logger.info("Load success roots category with size: {}",categoryResDtos.size());
            return categoryResDtos;

        } catch (Exception e) {
            logger.error("Error get roots ", e);
            return categoryResDtos;
        }
    }
}
