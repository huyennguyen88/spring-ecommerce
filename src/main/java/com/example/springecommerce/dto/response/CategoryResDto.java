package com.example.springecommerce.dto.response;

import com.example.springecommerce.entity.Category;
import com.example.springecommerce.entity.CategoryDetail;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class CategoryResDto implements Serializable {
    private int id;
    private String name;
    private List<CategoryResDto> children;

    public CategoryResDto(CategoryDetail categoryDetail) {
        Category category = categoryDetail.getCategory();
        this.id = category.getId();
        this.name = category.getName();
        this.children = new ArrayList<>();
        if (category.getCategoryDetails().isEmpty()) {
            this.children = Collections.emptyList();
        } else {
            for (CategoryDetail cd : category.getCategoryDetails()) {
                this.children.add(new CategoryResDto(cd));
            }
        }
    }

}
