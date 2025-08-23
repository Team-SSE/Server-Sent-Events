package com.sse.sse.dto.response;

import com.sse.sse.aggregate.Post;

import java.time.LocalDateTime;

public class PostResponseDto {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private String memberNickname;
    private int likesCount;

    public PostResponseDto() {
    }

    public PostResponseDto(final Long id, final String title, final LocalDateTime createdAt,
                           final String memberNickname, final int likesCount) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.memberNickname = memberNickname;
        this.likesCount = likesCount;
    }

    public static PostResponseDto of(final Post post) {
        return new PostResponseDto(post.getId(), post.getTitle(), post.getCreatedAt(),
                (post.getMember() == null) ? "알수없음" : post.getMember().getNickname(), post.getLikes().size());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt +
                ", nickname='" + memberNickname + '\'' +
                ", likesCount=" + likesCount +
                '}';
    }
}