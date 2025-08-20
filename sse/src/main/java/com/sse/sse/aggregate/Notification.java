package com.sse.sse.aggregate;

import java.time.LocalDateTime;

public class Notification {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private boolean isRead;
    private Long memberId;

    public Notification() {
    }
}