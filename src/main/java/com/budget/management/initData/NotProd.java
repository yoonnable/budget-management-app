package com.budget.management.initData;

import com.budget.management.category.entity.Category;
import com.budget.management.category.repository.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile({"dev", "test"})
public class NotProd {
    @Bean
    CommandLineRunner initData(CategoryRepository categoryRepository) {

        return args -> {
            // Category 생성
            List<Category> categoryList = new ArrayList<>();
            Category c1 = Category.builder().name("식비").build();
            Category c2 = Category.builder().name("교통").build();
            Category c3 = Category.builder().name("쇼핑").build();

            categoryList.addAll(List.of(c1, c2, c3));
            categoryRepository.saveAll(categoryList);
        };
    }
}
