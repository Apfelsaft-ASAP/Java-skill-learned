package com.sparta.hanghaeboard.repository;

import com.sparta.hanghaeboard.dto.BoardResponseDto;
import com.sparta.hanghaeboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<BoardResponseDto> findAllByOrderByCreatedAtDesc();
//    Optional<Board> findByIdandUserId(Long id, Long userid);
}
