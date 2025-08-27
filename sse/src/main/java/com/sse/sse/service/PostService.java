package com.sse.sse.service;

import com.sse.sse.aggregate.Member;
import com.sse.sse.aggregate.Post;
import com.sse.sse.dto.request.PostRequestDto;
import com.sse.sse.repository.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostService {
    private final PostRepository postRepository;

    public PostService() {
        postRepository = new PostRepository();
    }

    public int registPost(final Member member, final PostRequestDto requestDto) {
        final Long id = postRepository.findLastPost() + 1;

        final Post post = new Post(id, requestDto.getTitle(), requestDto.getContent(), member);

        return postRepository.registPost(post);
    }

    public List<Post> findAllPosts() {
        return postRepository.findAllPosts();
    }

    public Optional<Post> findPostById(final Long id) {
        return postRepository.findPostById(id);
    }

    public int removePost(final Post post) {
        return postRepository.removePost(post);
    }

    public int modifyPost(final Post post, final PostRequestDto requestDto) {
        if (requestDto.getTitle() != null) {
            post.setTitle(requestDto.getTitle());
        }

        if (requestDto.getContent() != null) {
            post.setContent(requestDto.getContent());
        }

        return postRepository.modifyPost(post);
    }
}