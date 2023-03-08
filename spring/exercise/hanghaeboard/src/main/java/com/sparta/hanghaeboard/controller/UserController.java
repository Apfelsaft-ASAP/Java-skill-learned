package com.sparta.hanghaeboard.controller;

import com.sparta.hanghaeboard.dto.LoginRequestDto;
import com.sparta.hanghaeboard.dto.SignupRequestDto;
import com.sparta.hanghaeboard.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequiredArgsConstructor
//    목적: @RestController는 RESTful Web Services를 구현하는 데 사용되는
//    컨트롤러를 나타내며, @Controller는 웹 애플리케이션에서의 일반적인 컨트롤러를 나타냅니다.
//
//    반환 타입: @RestController는 JSON, XML 등의 데이터를 반환하는 것이 기본이며,
//    @Controller는 뷰 템플릿을 반환하는 것이 기본입니다.
//
//    사용: 만약 RESTful Web Services 구현이 필요하다면 @RestController를,
//    일반적인 컨트롤러 구현이 필요하다면 @Controller를 사용하시면 됩니다.
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return "success";
    }
}
