package com.budget.management.budget.service;

import com.budget.management.budget.dto.AddBudgetRequest;
import com.budget.management.budget.dto.BudgetRequest;
import com.budget.management.budget.dto.UpdateBudgetRequest;
import com.budget.management.budget.entity.Budget;
import com.budget.management.budget.repository.BudgetRepository;
import com.budget.management.category.entity.Category;
import com.budget.management.category.repository.CategoryRepository;
import com.budget.management.member.entity.Member;
import com.budget.management.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final MemberRepository memberRepository;
    private final CategoryRepository categoryRepository;

    // 예산 설정(저장)
    public List<Budget> save(AddBudgetRequest request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("not found Member: " + request.getMemberId()));
        List<Budget> budgets = new ArrayList<>();
        for(BudgetRequest budgetRequest : request.getBudgets()) {
            Category category = categoryRepository.findById(budgetRequest.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("not found Category: " + budgetRequest.getCategoryId()));
            budgets.add(new Budget(budgetRequest, member, category));
        }
        return budgetRepository.saveAll(budgets);
    }

    // 예산 수정
    public Budget update(long id, UpdateBudgetRequest request) throws Exception {
        Budget budget = budgetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found Budget: " + id));
        if(request.getMemberId() != budget.getId()) {
            throw new Exception("[Error] No match Member: " + request.getMemberId());
        }
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("not found Category: " + request.getCategoryId()));
        budget.update(category, request.getMoney(), request.getPeriod());

        return budget;
    }
}
