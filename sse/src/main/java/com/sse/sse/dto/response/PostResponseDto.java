package com.sse.sse.dto.response;

import com.sse.sse.aggregate.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostResponseDto {
    private Long id;
    private String title;
    private LocalDateTime createdAt;
    private String nickname;
    private int likesCount;

    public PostResponseDto() {
    }

    public PostResponseDto(final Long id, final String title, final LocalDateTime createdAt,
                           final String nickname, final int likesCount) {
        this.id = id;
        this.title = title;
        this.createdAt = createdAt;
        this.nickname = nickname;
        this.likesCount = likesCount;
    }

    public static PostResponseDto of(final Post post) {
        return new PostResponseDto(post.getId() + 1, post.getTitle(), post.getCreatedAt(),
                (post.getMember() == null) ? "알 수 없음" : post.getMember().getNickname(), post.getLikes().size());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) +
                ", nickname='" + nickname + '\'' +
                ", likesCount=" + likesCount +
                '}';
    }
}