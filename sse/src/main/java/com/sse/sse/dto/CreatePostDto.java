package com.sse.sse.dto;

public class CreatePostDto {
    private String title;
    private String content;

    public CreatePostDto() {
    }

    public CreatePostDto(final String title, final String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}