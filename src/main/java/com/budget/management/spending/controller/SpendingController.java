package com.budget.management.spending.controller;

import com.budget.management.spending.dto.AddSpendingRequest;
import com.budget.management.spending.dto.UpdateSpendingRequest;
import com.budget.management.spending.entity.Spending;
import com.budget.management.spending.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    // 예산 수정
    @PutMapping("/{id}")
    public ResponseEntity<Spending> updateSpending(@PathVariable long id, @RequestBody UpdateSpendingRequest request) throws Exception {
        Spending spending = spendingService.update(id, request);
        return ResponseEntity.ok().body(spending);
    }
}
