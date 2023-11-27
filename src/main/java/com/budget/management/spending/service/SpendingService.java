package com.budget.management.spending.service;

import com.budget.management.category.entity.Category;
import com.budget.management.category.service.CategoryService;
import com.budget.management.member.entity.Member;
import com.budget.management.member.service.MemberService;
import com.budget.management.spending.dto.AddSpendingRequest;
import com.budget.management.spending.entity.Spending;
import com.budget.management.spending.repository.SpendingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpendingService {

    private final SpendingRepository spendingRepository;
    private final MemberService memberService;
    private final CategoryService categoryService;


    // 지출 생성
    public Spending save(AddSpendingRequest request) {
        Member member = memberService.findById(request.getMemberId());
        Category category = categoryService.findById(request.getCategoryId());
        return spendingRepository.save(new Spending(request, member, category));
    }
}