package com.budget.management.budget.dto;

import com.budget.management.budget.entity.Budget;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddBudgetRequest {
    private Long memberId;
    List<BudgetRequest> budgets;
}
