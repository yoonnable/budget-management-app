package com.budget.management.spending.dto;

import com.budget.management.spending.entity.Spending;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SpendingDetailResponse {
    private final Long id;
    private final String memberName;
    private final String categoryName;
    private final LocalDateTime date;
    private final int money;
    private final String memo;
    private final String exceptFlag;

    public SpendingDetailResponse(Spending spending) {
        this.id = spending.getId();
        this.memberName = spending.getMember().getName();
        this.categoryName = spending.getCategory().getName();
        this.date = spending.getDate();
        this.money = spending.getMoney();
        this.memo = spending.getMemo();
        this.exceptFlag = spending.getExceptFlag() == '0'? "합계 포함" : "합계 제외";
    }

}
