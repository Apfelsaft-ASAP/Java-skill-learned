package com.sparta.hanghaeboard.entity;

import com.sparta.hanghaeboard.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Comment extends Timestamped{

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column
    private String username;

    @Column
    private Long postId;

    @ManyToOne
    @JoinColumn(name = "Board_ID", nullable = false)
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_ID")
    private User user;

    public Comment(CommentRequestDto commentRequestDto, Board board, User user) {
        this.postId = board.getId();
        this.content = commentRequestDto.getContent();
        this.username = user.getUsername();
        this.board = board;
        this.user = user;

    }

    public void update(CommentRequestDto commentRequestDto) {

        this.content = commentRequestDto.getContent();
    }
}
