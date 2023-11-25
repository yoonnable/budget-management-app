package com.budget.management.budget.dto;

import lombok.Getter;

@Getter
public class UpdateBudgetRequest {
    private Long memberId;
    private Long categoryId;
    private int money;
    private int period;
}
