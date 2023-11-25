package com.budget.management.budget.entity;

import com.budget.management.budget.dto.AddBudgetRequest;
import com.budget.management.category.entity.Category;
import com.budget.management.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(nullable = false)
    private int money;

    @Column(nullable = false)
    private int period;

    @Builder
    public Budget(AddBudgetRequest budgetRequest, Member member, Category category) {
        this.member = member;
        this.category = category;
        this.money = budgetRequest.getMoney();
        this.period = budgetRequest.getPeriod();
    }

    public void update(Category category, int money, int period) {
        this.category = category;
        this.money = money;
        this.period = period;
    }

}
