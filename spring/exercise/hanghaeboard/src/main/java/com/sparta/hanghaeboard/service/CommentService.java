package com.sparta.hanghaeboard.service;

import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.sparta.hanghaeboard.dto.CommentRequestDto;
import com.sparta.hanghaeboard.dto.CommentResponseDto;
import com.sparta.hanghaeboard.entity.Board;
import com.sparta.hanghaeboard.entity.Comment;
import com.sparta.hanghaeboard.entity.User;
import com.sparta.hanghaeboard.entity.UserRoleEnum;
import com.sparta.hanghaeboard.jwt.JwtUtil;
import com.sparta.hanghaeboard.repository.BoardRepository;
import com.sparta.hanghaeboard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserService userService;
    private final BoardService boardService;
    private final JwtUtil jwtUtil;

    @Transactional
    public CommentResponseDto createComment(CommentRequestDto commentRequestDto, HttpServletRequest request) {
        User user = userService.tokenCheck(request);
        Board board = boardRepository.findById(commentRequestDto.getPostId()).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );

        Comment comment = commentRepository.saveAndFlush(new Comment(commentRequestDto, board, user));
        return new CommentResponseDto(comment);
    }

    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto, HttpServletRequest request) {
        User user = userService.tokenCheck(request);
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if(user.getUsername().equals(comment.getUsername()) || UserRoleEnum.ADMIN.equals(user.getRole())) {
            comment.update(commentRequestDto);
        }
        else{
            throw new IllegalArgumentException("등록한 게시물을 수정할 수 없습니다.");
        }
        return new CommentResponseDto(comment);
    }

    public CommentResponseDto deleteComment(Long id, CommentRequestDto commentRequestDto, HttpServletRequest request) {
        User user = userService.tokenCheck(request);
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시물이 존재하지 않습니다.")
        );
        if(user.getUsername().equals(comment.getUsername()) || UserRoleEnum.ADMIN.equals(user.getRole())) {
            comment.update(commentRequestDto);
        }
        else{
            throw new IllegalArgumentException("등록한 게시물을 수정할 수 없습니다.");
        }
        return new CommentResponseDto(comment);
    }
}
