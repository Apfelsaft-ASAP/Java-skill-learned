package com.sparta.hanghaeexam1.repository;

import com.sparta.hanghaeexam1.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
