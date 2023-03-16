package com.sparta.examboard.service;

import com.sparta.examboard.dto.PostRequestDto;
import com.sparta.examboard.dto.PostResponseDto;
import com.sparta.examboard.entity.Post;
import com.sparta.examboard.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto req) {
        Post post = postRepository.saveAndFlush(new Post(req));

        return new PostResponseDto(post);
    }

    @Transactional
    public List<PostResponseDto> findAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostResponseDto> postResponseDtos = new ArrayList<>();

        for(Post post : posts) {
            postResponseDtos.add(new PostResponseDto(post));
        }
        return postResponseDtos;
    }
}
