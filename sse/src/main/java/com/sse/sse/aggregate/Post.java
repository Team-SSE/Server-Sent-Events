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
    private Member member;
    private List<Member> likes;

    public Post() {
    }

    public Post(Long id, String title, String content, Member member) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = LocalDateTime.now();
        this.member = member;
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

    public Member getMember() {
        return member;
    }

    public List<Member> getLikes() {
        return likes;
    }

    public void addLikes(Member member) {
        if (this.likes == null) {
            this.likes = new ArrayList<>();
        }
        this.likes.add(member);
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", member=" + member +
                ", likesCount=" + likes.size() +
                '}';
    }
}