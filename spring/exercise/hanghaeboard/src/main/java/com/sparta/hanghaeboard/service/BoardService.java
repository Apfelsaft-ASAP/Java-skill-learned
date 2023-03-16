package com.sparta.hanghaeboard.service;

import com.sparta.hanghaeboard.dto.BoardRequestDto;
import com.sparta.hanghaeboard.dto.BoardCommentResponseDto;
import com.sparta.hanghaeboard.dto.SecurityExceptionDto;
import com.sparta.hanghaeboard.entity.Board;
import com.sparta.hanghaeboard.entity.User;
import com.sparta.hanghaeboard.entity.UserRoleEnum;
import com.sparta.hanghaeboard.exception.ApiException;
import com.sparta.hanghaeboard.exception.ExceptionEnum;
import com.sparta.hanghaeboard.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    //게시글 전체목록 조회
    @Transactional(readOnly = true)
    public List<BoardCommentResponseDto> getBoards() {
        List<BoardCommentResponseDto> boardCommentResponseDtos = new ArrayList<>();
        List<Board> boards = boardRepository.findAllByOrderByCreatedAtDesc();

        for (Board board : boards) {
            boardCommentResponseDtos.add(new BoardCommentResponseDto(board));
        }
        return boardCommentResponseDtos;
    }

    //게시글 상세조회하기
    public BoardCommentResponseDto getBoardId(Long id) {
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new ApiException(ExceptionEnum.NOT_FOUND_USER)
        );
        return new BoardCommentResponseDto(board);
    }

    //게시글 등록하기
    @Transactional
    public BoardCommentResponseDto createBoard(BoardRequestDto boardRequestDto, User user) {
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
//        User user = userService.tokenCheck(request);

        Board board = boardRepository.saveAndFlush(new Board(boardRequestDto, user));

        return new BoardCommentResponseDto(board);
    }

    //게시글 수정하기
    @Transactional
    public BoardCommentResponseDto updateBoard(Long id, BoardRequestDto boardRequestDto, User user) {


        Board board = boardRepository.findById(id).orElseThrow(
                () -> new ApiException(ExceptionEnum.NOT_FOUND_BOARD_ALL)
        );
        if (user.getUsername().equals(board.getUsername()) || UserRoleEnum.ADMIN.equals(user.getRole())) {
            board.update(boardRequestDto);
        } else {
            throw new ApiException(ExceptionEnum.NOT_FOUND_BOARD);
        }
        return new BoardCommentResponseDto(board);
    }

    //게시글 삭제하기
    public SecurityExceptionDto deleteBoard(Long id, User user) {

        Board board = boardRepository.findById(id).orElseThrow(
                () -> new ApiException(ExceptionEnum.NOT_FOUND_BOARD_ALL)
        );
        if (user.getUsername().equals(board.getUsername()) || UserRoleEnum.ADMIN.equals(user.getRole())) {
            boardRepository.deleteById(id);
        } else {
            throw new ApiException(ExceptionEnum.NOT_FOUND_DELETEBOARD);
        }
        return new SecurityExceptionDto(HttpStatus.OK.value(),"삭제완료");
    }


}



