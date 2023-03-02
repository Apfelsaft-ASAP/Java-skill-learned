package com.sparta.hanghaeboard.controller;

import com.sparta.hanghaeboard.dto.BoardRequestDto;
import com.sparta.hanghaeboard.entity.Board;
import com.sparta.hanghaeboard.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;


    @GetMapping("/api/boards/")
    public List<Board> getBoard() {return boardService.getBoards();}

    @GetMapping("api/board/{id}")
    public Board getBoardByid(@PathVariable Long id) {
        return boardService.getBoardByid(id);
    }

    @PostMapping("/api/board/")
    public Board createBoard(@RequestBody BoardRequestDto requestDto) {

        return boardService.createBoard(requestDto);
    }

    @PutMapping("/api/board/{id}")
    public Long updateBoard(@PathVariable Long id,@RequestBody BoardRequestDto requestDto, @RequestParam(value = "password")String password) {
        return boardService.update(id, requestDto, password);
    }

    @DeleteMapping("/api/board/{id}")
    public Long deleteBoard(@PathVariable Long id, @RequestParam(value = "password")String password) {
        return boardService.delteMemo(id, password);
    }
}
