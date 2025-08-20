package com.sse.sse.service;

import com.sse.sse.aggregate.Post;
import com.sse.sse.dto.CreatePostDto;
import com.sse.sse.repository.PostRepository;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public int registPost(CreatePostDto requestDto) {
        final Long id = postRepository.findLastPost() + 1;

        // TODO: 로그인한 회원의 id로 수정
        final Post post = new Post(id, requestDto.getTitle(), requestDto.getContent(), null);

        return postRepository.registPost(post);
    }
}
