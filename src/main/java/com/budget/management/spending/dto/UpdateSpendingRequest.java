package com.budget.management.spending.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class UpdateSpendingRequest {
    private Long memberId;
    private Long categoryId;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime date;
    private int money;
    private String memo;
    private char exceptFlag;
}
