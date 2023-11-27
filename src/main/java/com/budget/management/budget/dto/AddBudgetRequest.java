package com.budget.management.budget.dto;

import com.budget.management.budget.entity.Budget;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AddBudgetRequest {
    private Long memberId;
    List<BudgetRequest> budgets;
}
