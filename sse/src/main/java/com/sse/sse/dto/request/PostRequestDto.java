package com.sse.sse.dto.request;

public class PostRequestDto {
    private String title;
    private String content;

    public PostRequestDto() {
    }

    public PostRequestDto(final String title, final String content) {
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