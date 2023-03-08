package com.sparta.hanghaeboard.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.regex.Pattern;

@Setter
@Getter
public class SignupRequestDto {
    private static final String USERNAME_PATTERN = "^[a-z|0-9]{4,10}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[A-Z|a-z])(?=.*\\d)[A-Z|a-z\\d]{8,15}$";
    private String username;
    private String password;

    public void setUsername(String username) {
        if(!Pattern.matches(USERNAME_PATTERN, username)) {
            throw new IllegalArgumentException("잘못된 이름입니다. 4~10자의 길이로 구성되어야 하며 소문자(a-z)와 숫자(0-9)만 포함되어야합니다.");
        }
        this.username = username;
    }

    public void setPassword(String password) {
        if(!Pattern.matches(PASSWORD_PATTERN, password)) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다. 8~15자의 길이로 구성되어야 하며 대소문자(a-z, A-Z)와 숫자(0-9)가 포함되어야합니다.");
        }
        this.password = password;
    }
}
