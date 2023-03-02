package com.sparta.hanghaeexam1.entity;

import com.sparta.hanghaeexam1.dto.MemberResponseDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String pw;

    public Member(MemberResponseDto memberResponseDto) {
        this.id = memberResponseDto.getId();
        this.name = memberResponseDto.getName();
        this.email = memberResponseDto.getEmail();
        this.pw = memberResponseDto.getPw();
    }
}
