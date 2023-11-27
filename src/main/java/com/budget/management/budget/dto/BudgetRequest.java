package com.budget.management.budget.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BudgetRequest {
    private Long categoryId;
    private int money;
    private int period;
}
