package com.sparta.hanghaeexam1.controller;

import com.sparta.hanghaeexam1.entity.Member;
import lombok.RequiredArgsConstructor;

import com.sparta.hanghaeexam1.service.MemberService;
import com.sparta.hanghaeexam1.dto.MemberResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /**
     * 한 회원의 userId가 주었을때 회원 정보를 조회하는 API
     *
     * @param id
     */
    @GetMapping("/member/{id}")
    public Member getMemberInfo(@PathVariable Long id) {
        return memberService.findMember(id);
    }

    /**
     * 회원의 전체 목록을 조회하는 API
     */
    @GetMapping("/member")
    public List<Member> getMemberList() {
        return memberService.findAllmember();
    }

    @PostMapping("/member/add")
    public Member createMember(@RequestBody MemberResponseDto memberResponseDto){
        return memberService.createMember(memberResponseDto);
    }

}