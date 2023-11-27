package com.budget.management.spending.dto;

import com.budget.management.spending.entity.Spending;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class SpendingDetailResponse {
    private final Long id;
    private final String memberName;
    private final String categoryName;
    private final LocalDateTime date;
    private final int momey;
    private final String memo;
    private final String exceptFlag;

    public SpendingDetailResponse(Spending spending) {
        this.id = spending.getId();
        this.memberName = spending.getMember().getName();
        this.categoryName = spending.getCategory().getName();
        this.date = spending.getDate();
        this.momey = spending.getMoney();
        this.memo = spending.getMemo();
        this.exceptFlag = spending.getExceptFlag() == '0'? "합계 포함" : "합계 제외";
    }

}
