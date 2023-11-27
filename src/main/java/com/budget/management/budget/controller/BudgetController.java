package com.budget.management.budget.controller;

import com.budget.management.budget.dto.AddBudgetRequest;
import com.budget.management.budget.dto.UpdateBudgetRequest;
import com.budget.management.budget.entity.Budget;
import com.budget.management.budget.service.BudgetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/budget")
@RequiredArgsConstructor
public class BudgetController {

    private final BudgetService budgetService;

    // 예산 설정(저장)
    @PostMapping("")
    public ResponseEntity<List<Budget>> addBudget(@RequestBody AddBudgetRequest request) {
        List<Budget> budgets = budgetService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(budgets);
    }

    // 예산 수정
    @PutMapping("/{id}")
    public ResponseEntity<Budget> updateBudget(@PathVariable long id, @RequestBody UpdateBudgetRequest request) throws Exception {
        Budget budget = budgetService.update(id, request);

        return ResponseEntity.ok().body(budget);
    }


}
