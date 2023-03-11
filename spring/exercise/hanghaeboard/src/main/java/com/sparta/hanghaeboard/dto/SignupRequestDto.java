package com.sparta.hanghaeboard.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class SignupRequestDto {
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "아이디는 알파벳 소문자와 숫자를 포함한 4-10자리여야 합니다.")
    private String username;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\\\d)(?=.*[!@#$%^&*])[A-Za-z\\\\d!@#$%^&*]{8,15}$", message = "비밀번호는 알파벳 대소문자와 숫자, 특수문자를 포함한 8-15자리여야 합니다.")
    private String password;

    private boolean admin;
    private String adminToken;
}
