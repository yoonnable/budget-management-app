package com.budget.management.budget.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BudgetRequest {
    private Long categoryId;
    private int money;
    private int period;
}
