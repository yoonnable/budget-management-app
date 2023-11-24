package com.budget.management.category.dto;

import com.budget.management.category.entity.Category;
import lombok.Getter;

@Getter
public class CategoryResponse {
    private final long id;
    private final String name;

    public CategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
