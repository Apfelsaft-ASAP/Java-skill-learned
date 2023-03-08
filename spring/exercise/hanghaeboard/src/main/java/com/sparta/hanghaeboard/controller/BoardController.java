package com.sparta.hanghaeboard.controller;

import com.sparta.hanghaeboard.dto.BoardRequestDto;
import com.sparta.hanghaeboard.entity.Board;
import com.sparta.hanghaeboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    //게시글 조회
    @GetMapping("/api/boards/")
    public List<Board> getBoard() {return boardService.getBoards();}

    //선택한 게시글 조회
    @GetMapping("api/board/{id}")
    public Board getBoardByid(@PathVariable Long id) {
        return boardService.getBoardByid(id);
    }

    //게시글 작성
    @PostMapping("/api/board/")
    public Board createBoard(@RequestBody BoardRequestDto requestDto, HttpServletRequest request) {
        //응답보내기
        return boardService.createBoard(requestDto, request);
    }

    //게시글 수정
    @PutMapping("/api/board/{id}")
    public Long updateBoard(@PathVariable Long id,@RequestBody BoardRequestDto requestDto, @RequestParam(value = "password")String password) {
        return boardService.update(id, requestDto, password);
    }

    //게시글 삭제
    @DeleteMapping("/api/board/{id}")
    public Long deleteBoard(@PathVariable Long id, @RequestParam(value = "password")String password) {
        return boardService.delteMemo(id, password);
    }
}
