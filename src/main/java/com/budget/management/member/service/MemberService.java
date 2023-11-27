package com.budget.management.member.service;

import com.budget.management.member.entity.Member;
import com.budget.management.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findById(long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("not found Member: " + id));
    }
}
