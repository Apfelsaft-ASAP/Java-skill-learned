package com.sparta.hanghaeexam1.service;

import com.sparta.hanghaeexam1.entity.Member;
import com.sparta.hanghaeexam1.dto.MemberResponseDto;
import com.sparta.hanghaeexam1.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member findMember(Long id) {
        return memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("회원 상세 조회 실패")
        );

    }

    public List<Member> findAllmember() {
        return memberRepository.findAll();


    }

    public Member createMember(MemberResponseDto memberResponseDto) {
        Member member = new Member(memberResponseDto);
        memberRepository.save(member);
        return member;
    }
}