package com.sse.sse.dto.response;

import com.sse.sse.aggregate.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostDetailResponseDto {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String nickname;
    private int likesCount;

    public PostDetailResponseDto() {
    }

    public PostDetailResponseDto(final Long id, final String title, final String content, final LocalDateTime createdAt,
                                 final String nickname, final int likesCount) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.nickname = nickname;
        this.likesCount = likesCount;
    }

    public static PostDetailResponseDto of(final Post post) {
        return new PostDetailResponseDto(post.getId(), post.getTitle(), post.getContent(), post.getCreatedAt(),
                (post.getMember() == null) ? "알 수 없음" : post.getMember().getNickname(), post.getLikes().size());
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")) +
                ", nickname='" + nickname + '\'' +
                ", likesCount=" + likesCount +
                '}';
    }
}