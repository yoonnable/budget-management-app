package com.budget.management.spending.entity;

import com.budget.management.category.entity.Category;
import com.budget.management.member.entity.Member;
import com.budget.management.spending.dto.AddSpendingRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;
import org.springframework.context.annotation.Description;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Spending {
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
    private LocalDateTime date;

    @Column(nullable = false)
    private int money;

    private String memo;

    @Column(nullable = false)
    @Comment(value = "합계 제외 flag : 제외 = 1, 포함 = 0")
    private char exceptFlag;

    @Builder
    public Spending(AddSpendingRequest request, Member member, Category category) {
        this.member = member;
        this.category = category;
        this.date = request.getDate();
        this.money = request.getMoney();
        this.memo = request.getMemo();
        this.exceptFlag = request.getExceptFlag();
    }


}
