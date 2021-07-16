package com.example.springecommerce.service.impl;

import com.example.springecommerce.dto.response.CategoryResDto;
import com.example.springecommerce.entity.CategoryDetail;
import com.example.springecommerce.service.CategoryDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CategoryDetailServiceImpl extends BaseServiceImpl implements CategoryDetailService {

    @Override
    public List<CategoryResDto> getRoots() {
        List<CategoryResDto> categoryResDtos = new ArrayList<>();
        try {
            List<CategoryDetail> categoryDetails = getCategoryDetailRepository().findByParentIsNull();
            for (CategoryDetail categoryDetail : categoryDetails) {
                categoryResDtos.add(new CategoryResDto(categoryDetail));
            }
            log.info("Load root done!");
            return categoryResDtos;

        } catch (Exception e) {
            log.error("Error get roots ", e);
            return categoryResDtos;
        }
    }
}
