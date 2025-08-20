package com.sse.sse.aggregate;

import java.time.LocalDateTime;
import java.util.List;

public class Post {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Long memberId;
    private List<Long> likes;

    public Post() {
    }
}