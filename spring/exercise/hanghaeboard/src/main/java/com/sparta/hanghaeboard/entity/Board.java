package com.sparta.hanghaeboard.entity;

import com.sparta.hanghaeboard.dto.BoardRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Board extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String username;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    @OrderBy(value = "createdAt DESC")
    private List<Comment> comments = new ArrayList<>();


    public Board(BoardRequestDto boardRequestDto, User user) {
        this.username = user.getUsername();
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.user = user;
    }

    public void update(BoardRequestDto boardRequestDto) {
        this.title = boardRequestDto.getTitle();
        this.content = boardRequestDto.getContent();
        this.username = username;
    }
}
