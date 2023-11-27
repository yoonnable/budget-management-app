package com.budget.management.spending.controller;

import com.budget.management.spending.dto.AddSpendingRequest;
import com.budget.management.spending.entity.Spending;
import com.budget.management.spending.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/spending")
@RequiredArgsConstructor
public class SpendingController {

    private final SpendingService spendingService;

    // 지출 생성
    @PostMapping("")
    public ResponseEntity<Spending> addSpending(@RequestBody AddSpendingRequest request) {
        Spending spending = spendingService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(spending);
    }
}
