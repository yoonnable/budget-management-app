package com.budget.management.spending.controller;

import com.budget.management.spending.dto.*;
import com.budget.management.spending.entity.Spending;
import com.budget.management.spending.service.SpendingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    // 지출 수정
    @PutMapping("/{id}")
    public ResponseEntity<Spending> updateSpending(@PathVariable long id, @RequestBody UpdateSpendingRequest request) throws Exception {
        Spending spending = spendingService.update(id, request);
        return ResponseEntity.ok().body(spending);
    }

    // 지출 상세 조회
    @GetMapping("/{id}")
    public ResponseEntity<SpendingDetailResponse> findSpending(@PathVariable long id) {
        Spending spending = spendingService.findById(id);
        return ResponseEntity.ok().body(new SpendingDetailResponse(spending));
    }

    // 지출 목록 조회
    @GetMapping("/list/{period}")
    public ResponseEntity<SpendingResponse> findAllSpending(@PathVariable String period, @RequestBody FindAllSpendingRequest request) {
        FindAllSpendingRequest requestDto = new FindAllSpendingRequest();
        if(request != null) {
            if(request.getCategoryId() != 0) {
                requestDto.setCategoryId(request.getCategoryId());
            }
            if(request.getMin() != 0) {
                requestDto.setMin(request.getMin());
            }
            if(request.getMax() != 0) {
                requestDto.setMax(request.getMax());
            }
        }

        List<SpendingDetailResponse> spendings = spendingService.findAllSpending(period, requestDto);

        // 총합계
        int total = 0;
        for(SpendingDetailResponse spending : spendings) {
            if(spending.getExceptFlag().equals("합계 포함")) {
                total += spending.getMoney();
            }
        }

        //조회된 카테고리별 합계
        Map<String, Integer> totalOfCategorys = new HashMap<>();
        for(SpendingDetailResponse spending : spendings) {
            if(spending.getExceptFlag().equals("합계 포함")) {
                String categoryName = spending.getCategoryName();
                int money = spending.getMoney();
                totalOfCategorys.put(categoryName, totalOfCategorys.getOrDefault(categoryName, 0) + money);
            }
        }

        SpendingResponse spendingResponse = new SpendingResponse(spendings, total, totalOfCategorys);
        return ResponseEntity.ok().body(spendingResponse);
    }

    // 지출 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Spending> deleteSpending(@PathVariable long id) {
        spendingService.delete(id);
        return ResponseEntity.ok().build();
    }

}
