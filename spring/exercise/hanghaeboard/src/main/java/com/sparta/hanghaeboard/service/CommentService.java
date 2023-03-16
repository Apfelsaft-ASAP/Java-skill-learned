package com.sparta.hanghaeboard.service;

import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.sparta.hanghaeboard.dto.CommentRequestDto;
import com.sparta.hanghaeboard.dto.CommentResponseDto;
import com.sparta.hanghaeboard.dto.SecurityExceptionDto;
import com.sparta.hanghaeboard.entity.Board;
import com.sparta.hanghaeboard.entity.Comment;
import com.sparta.hanghaeboard.entity.User;
import com.sparta.hanghaeboard.entity.UserRoleEnum;
import com.sparta.hanghaeboard.exception.ApiException;
import com.sparta.hanghaeboard.exception.ExceptionEnum;
import com.sparta.hanghaeboard.jwt.JwtUtil;
import com.sparta.hanghaeboard.repository.BoardRepository;
import com.sparta.hanghaeboard.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
    public CommentResponseDto createComment(CommentRequestDto commentRequestDto, User user) {
        Board board = boardRepository.findById(commentRequestDto.getPostId()).orElseThrow(
                () -> new ApiException(ExceptionEnum.NOT_FOUND_COMMENT_ALL)
        );

        Comment comment = commentRepository.saveAndFlush(new Comment(commentRequestDto, board, user));
        return new CommentResponseDto(comment);
    }

    public CommentResponseDto updateComment(Long id, CommentRequestDto commentRequestDto, User user) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ApiException(ExceptionEnum.NOT_FOUND_COMMENT_ALL)
        );
        if(user.getUsername().equals(comment.getUsername()) || UserRoleEnum.ADMIN.equals(user.getRole())) {
            comment.update(commentRequestDto);
        }
        else{
            throw new ApiException(ExceptionEnum.NOT_FOUND_COMMENT);
        }
        return new CommentResponseDto(comment);
    }

    @Transactional
    public SecurityExceptionDto deleteComment(Long id, User user) {
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ApiException(ExceptionEnum.NOT_FOUND_COMMENT_ALL)
        );

        SecurityExceptionDto result = new SecurityExceptionDto();
        if(user.getUsername().equals(comment.getUsername()) || UserRoleEnum.ADMIN.equals(user.getRole())) {
            commentRepository.deleteById(id);
            result.setHttpStatus(HttpStatus.OK.value(), "댓글 삭제 성공");
            return result;
        }
        else{
            result.setHttpStatus(HttpStatus.BAD_REQUEST.value(), "댓글 삭제 실패");
            return result;
        }

    }
}
