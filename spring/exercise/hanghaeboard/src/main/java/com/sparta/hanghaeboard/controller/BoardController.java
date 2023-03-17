package com.sparta.hanghaeboard.controller;
//
import com.sparta.hanghaeboard.dto.BoardRequestDto;
import com.sparta.hanghaeboard.dto.BoardCommentResponseDto;
import com.sparta.hanghaeboard.dto.SecurityExceptionDto;
import com.sparta.hanghaeboard.security.UserDetailsImpl;
import com.sparta.hanghaeboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BoardController {
    private final BoardService boardService;

    //게시판 목록 조회하기
    @GetMapping("/boards")
    public List<BoardCommentResponseDto> getBoards(){
        return boardService.getBoards();
    }

    @GetMapping("/api/boards/{id}")
    public BoardCommentResponseDto getBoardId(@PathVariable Long id) {
        return boardService.getBoardId(id);
    }

    //게시판 등록하기
    @PostMapping("/board")
    public BoardCommentResponseDto createBoard(@RequestBody BoardRequestDto boardRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.createBoard(boardRequestDto, userDetails.getUser());
    }
    //게시판 수정하기
    @PutMapping("/board/{id}")
    public BoardCommentResponseDto updateBoard(@PathVariable Long id, @RequestBody BoardRequestDto boardRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.updateBoard(id, boardRequestDto, userDetails.getUser());
    }

    //게시판 삭제하기
    @DeleteMapping("/board/{id}")
    public SecurityExceptionDto deleteBoard(@PathVariable Long id, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return boardService.deleteBoard(id, userDetails.getUser());
    }

}
