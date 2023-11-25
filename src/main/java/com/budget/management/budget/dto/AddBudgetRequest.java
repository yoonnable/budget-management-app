package com.budget.management.budget.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddBudgetRequest {
    private Long memberId;
    private Long categoryId;
    private int money;
    private int period;
}
