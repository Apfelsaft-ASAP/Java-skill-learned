package com.sparta.hanghaeboard.service;

import com.sparta.hanghaeboard.dto.BoardRequestDto;
import com.sparta.hanghaeboard.dto.BoardResponseDto;
import com.sparta.hanghaeboard.dto.StatusResponseDto;
import com.sparta.hanghaeboard.entity.Board;
import com.sparta.hanghaeboard.entity.User;
import com.sparta.hanghaeboard.entity.UserRoleEnum;
import com.sparta.hanghaeboard.jwt.JwtUtil;
import com.sparta.hanghaeboard.repository.BoardRepository;
import com.sparta.hanghaeboard.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtUtil jwtUtil;


    @Transactional(readOnly = true)
    public List<BoardResponseDto> getBoards() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    @Transactional
    public BoardResponseDto createBoard(BoardRequestDto boardRequestDto, HttpServletRequest request) {
//        //Request에서 Token 가져오기
//        String token = jwtUtil.resolveToken(request);
//        Claims claims;
//
//        //토큰이 있는 경우에만 게시물 작성 가능
//        if (token != null) {
//            if (jwtUtil.validateToken(token)) {
//                claims = jwtUtil.getUserInfoFromToken(token);
//            } else {
//                throw new IllegalArgumentException("Token Error");
//            }
//
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
//            );
        User user = userService.tokenCheck(request);

        Board board = boardRepository.saveAndFlush(new Board(boardRequestDto, user.getUsername()));

        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto, HttpServletRequest request) {

        User user = userService.tokenCheck(request);

        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if (user.getUsername().equals(board.getUsername()) || UserRoleEnum.ADMIN.equals(user.getRole())) {
            board.update(boardRequestDto);
        } else {
            throw new IllegalArgumentException("등록한 게시물을 수정할 수 있습니다.");
        }
        return new BoardResponseDto(board);
    }

    public StatusResponseDto deleteBoard(Long id, HttpServletRequest request) {

        User user = userService.tokenCheck(request);

        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if (user.getUsername().equals(board.getUsername()) || UserRoleEnum.ADMIN.equals(user.getRole())) {
            boardRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("등록한 게시물만 삭제할 수 있습니다.");
        }
        return new StatusResponseDto("삭제완료", HttpStatus.OK.value());
    }

    public Board findBoard(Long id) {
        return boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글이 존재하지 않습니다.")
        );
    }
}



