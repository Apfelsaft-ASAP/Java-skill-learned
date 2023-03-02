package com.sparta.hanghaeboard.entity;


import com.sparta.hanghaeboard.dto.BoardRequestDto;
import com.sparta.hanghaeboard.entity.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Board extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String titles;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contents;

    public boolean getPassword(String password) {
        return this.password.equals(password);
    }

    public Board(BoardRequestDto requestDto) {
        this.titles = requestDto.getTitles();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }


    public void update(BoardRequestDto requestDto) {
        this.titles = requestDto.getTitles();
        this.username = requestDto.getUsername();
        this.password = requestDto.getPassword();
        this.contents = requestDto.getContents();
    }
}
