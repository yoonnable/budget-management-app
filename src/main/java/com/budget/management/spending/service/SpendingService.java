package com.budget.management.spending.service;

import com.budget.management.category.entity.Category;
import com.budget.management.category.service.CategoryService;
import com.budget.management.member.entity.Member;
import com.budget.management.member.service.MemberService;
import com.budget.management.spending.dto.AddSpendingRequest;
import com.budget.management.spending.dto.FindAllSpendingRequest;
import com.budget.management.spending.dto.SpendingDetailResponse;
import com.budget.management.spending.dto.UpdateSpendingRequest;
import com.budget.management.spending.entity.Spending;
import com.budget.management.spending.repository.SpendingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SpendingService {

    private final SpendingRepository spendingRepository;
    private final MemberService memberService;
    private final CategoryService categoryService;


    // 지출 생성
    public Spending save(AddSpendingRequest request) {
        Member member = memberService.findById(request.getMemberId());
        Category category = categoryService.findById(request.getCategoryId());
        return spendingRepository.save(new Spending(request, member, category));
    }

    // 지출 수정
    public Spending update(long id, UpdateSpendingRequest request) throws Exception {
        Spending spending = spendingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found Spending: " + id));
        if(request.getMemberId() != spending.getId()) {
            throw  new Exception("[Error] No match Member: " + request.getMemberId());
        }
        Category category = categoryService.findById(request.getCategoryId());
        spending.update(request, category);

        return spending;
    }

    // 지출 상세 조회
    public Spending findById(long id) {
        return spendingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found Spending: " + id));
    }

    // 지출 목록 조회
    public List<SpendingDetailResponse> findAllSpending(String period, FindAllSpendingRequest request) {
        List<SpendingDetailResponse> spendings = findAllSpendingByFilter(period, request)
                .stream()
                .map(SpendingDetailResponse::new)
                .toList();
        return spendings;
    }

    private List<Spending> findAllSpendingByFilter(String period, FindAllSpendingRequest request) {
        String month = period.substring(2);
        String endDate = "31";
        switch (month) {
            case "04","06","09","11" : endDate = "30";
            case "02": endDate = "28";
        }
        String startDt = period + "01";
        String endDt = period + endDate;
        if(request.getCategoryId() == 0) {
            return spendingRepository.findByBasic(startDt, endDt, request.getMin(), request.getMax());
        }
        return spendingRepository.findByCategoryId(startDt,endDt, request.getMin(), request.getMax(), request.getCategoryId());
    }
}