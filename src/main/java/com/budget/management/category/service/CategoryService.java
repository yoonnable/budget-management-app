package com.budget.management.category.service;

import com.budget.management.category.dto.AddCategoryRequest;
import com.budget.management.category.entity.Category;
import com.budget.management.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;

    // 카테고리 생성
    public Category save(AddCategoryRequest request) {
        return categoryRepository.save(new Category(request));
    }

    // 카테고리 목록 조회
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
