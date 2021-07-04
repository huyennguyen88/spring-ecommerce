package com.example.springecommerce.dto.response;

import com.example.springecommerce.entity.Category;
import com.example.springecommerce.entity.CategoryDetail;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CategoryResDto> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryResDto> children) {
        this.children = children;
    }
}
