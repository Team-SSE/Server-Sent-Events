package com.sse.sse.aggregate;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Post implements Serializable {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Long memberId;
    private List<Long> likes;

    public Post() {
    }

    public Post(Long id, String title, String content, Long memberId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.memberId = memberId;
        this.likes = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public Long getMemberId() {
        return memberId;
    }

    public List<Long> getLikes() {
        return likes;
    }

    public void addLikes(Long memberId) {
        if (this.likes == null) {
            this.likes = new ArrayList<>();
        }
        this.likes.add(memberId);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", memberId=" + memberId +
                ", likes=" + likes +
                '}';
    }
}