package com.sparta.hanghaeboard.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class SecurityExceptionDto {
    private String msg;
    private int statusCode;

    public SecurityExceptionDto(int statusCode, String msg) {
        this.msg = msg;
        this.statusCode = statusCode;
    }

    public void setHttpStatus(int statusCode, String msg) {
        this.msg = msg;
        this.statusCode = statusCode;
    }
}
