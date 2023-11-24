package com.budget.management.category.controller;

import com.budget.management.category.dto.AddCategoryRequest;
import com.budget.management.category.entity.Category;
import com.budget.management.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;

    // 카테고리 생성
    @PostMapping("")
    public ResponseEntity<Category> addCategory(@RequestBody AddCategoryRequest request) {
        Category category = categoryService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(category);
    }
}
