package com.sparta.examboard.controller;

import com.sparta.examboard.dto.PostRequestDto;
import com.sparta.examboard.dto.PostResponseDto;
import com.sparta.examboard.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    @PostMapping("/post")
    public PostResponseDto createPost(@RequestBody PostRequestDto req) {
        return postService.createPost(req);
    }

    @GetMapping("/post")
    public List<PostResponseDto> getPostList() {
        return postService.findAllPost();
    }
}
