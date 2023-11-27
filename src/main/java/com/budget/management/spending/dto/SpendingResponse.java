package com.budget.management.spending.dto;

import com.budget.management.spending.entity.Spending;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
public class SpendingResponse {
    private final List<SpendingDetailResponse> spendings;
    private final int total;
    private final Map<String, Integer> totalOfCategorys;

    public SpendingResponse(List<SpendingDetailResponse> spendings, int total, Map<String, Integer> totalOfCategorys) {
        this.spendings = spendings;
        this.total = total;
        this.totalOfCategorys = totalOfCategorys;
    }
}
