package com.budget.management.spending.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindAllSpendingRequest {
    private int categoryId = 0;
    private int min = Integer.MIN_VALUE;
    private int max = Integer.MAX_VALUE;
}
