package com.budget.management.common.dto;

import lombok.Getter;

@Getter
public class CommonApiResponse {
    private int statusCode;
    private String statusMessage;

    public CommonApiResponse(int statusCode, String statusMessage) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
