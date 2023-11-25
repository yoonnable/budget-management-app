package com.budget.management.initData;

import com.budget.management.category.entity.Category;
import com.budget.management.category.repository.CategoryRepository;
import com.budget.management.member.entity.Member;
import com.budget.management.member.repository.MemberRepository;
import com.budget.management.util.Ut;
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
    CommandLineRunner initData(MemberRepository memberRepository, CategoryRepository categoryRepository) {

        String password = Ut.encrypt.encryptPW("1234");
        return args -> {
            // Member 생성
            List<Member> members = new ArrayList<>();
            Member m1 = Member.builder()
                    .name("user1")
                    .password(password)
                    .build();

            Member m2 = Member.builder()
                    .name("user2")
                    .password(password)
                    .build();

            Member m3 = Member.builder()
                    .name("user3")
                    .password(password)
                    .build();

            members.addAll((List.of(m1, m2, m3)));
            memberRepository.saveAll(members);

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
