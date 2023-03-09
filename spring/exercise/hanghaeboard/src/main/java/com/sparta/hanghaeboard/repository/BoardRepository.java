package com.sparta.hanghaeboard.repository;

import com.sparta.hanghaeboard.dto.BoardResponseDto;
import com.sparta.hanghaeboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<BoardResponseDto> findAllByOrderByModifiedAtDesc();
    Optional<Board> findByIdAndUserId(Long id, Long userId);
}
