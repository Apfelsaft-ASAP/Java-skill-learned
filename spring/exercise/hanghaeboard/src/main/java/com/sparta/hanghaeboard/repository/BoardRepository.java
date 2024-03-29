package com.sparta.hanghaeboard.repository;
//
import com.sparta.hanghaeboard.dto.BoardCommentResponseDto;
import com.sparta.hanghaeboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByOrderByCreatedAtDesc();
//    Optional<Board> findByIdandUserId(Long id, Long userid);
}
