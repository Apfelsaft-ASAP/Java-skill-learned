package com.sparta.hanghaeboard.dto;

import com.sparta.hanghaeboard.entity.Comment;

import java.time.LocalDateTime;

public class CommentResponseDto {
    private Long id;

    private String content;

    private String username;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public CommentResponseDto(Comment comment) {
        this.content = comment.getContent();
        this.username = comment.getUsername();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
