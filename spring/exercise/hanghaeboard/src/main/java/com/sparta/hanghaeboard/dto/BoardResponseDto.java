package com.sparta.hanghaeboard.dto;

import com.sparta.hanghaeboard.entity.Board;
import com.sparta.hanghaeboard.entity.Comment;
import com.sparta.hanghaeboard.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    private final List<CommentResponseDto> commentList = new ArrayList<>();

    public BoardResponseDto(Board board) {
        this.id = board.getId();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.username = board.getUsername();
        this.createdAt = board.getCreatedAt();
        this.modifiedAt = board.getModifiedAt();

        for(Comment comment : board.getComment()) {
            commentList.add(new CommentResponseDto(comment));
        }
    }
}
