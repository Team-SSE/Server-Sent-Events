package com.sse.sse.service;

import com.sse.sse.aggregate.Member;
import com.sse.sse.aggregate.Post;
import com.sse.sse.dto.CreatePostDto;
import com.sse.sse.repository.PostRepository;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public int registPost(final Member member, final CreatePostDto requestDto) {
        final Long id = postRepository.findLastPost() + 1;

        final Post post = new Post(id, requestDto.getTitle(), requestDto.getContent(), member);

        return postRepository.registPost(post);
    }
}
