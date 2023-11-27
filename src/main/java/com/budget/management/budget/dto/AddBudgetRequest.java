package com.budget.management.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddBudgetRequest {
    private Long memberId;
    List<BudgetRequest> budgets;
}
