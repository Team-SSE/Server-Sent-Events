package com.sse.sse.controller;

import com.sse.sse.dto.CreatePostDto;
import com.sse.sse.service.PostService;

import java.util.Scanner;

public class PostController {
    private final PostService postService;

    public PostController() {
        postService = new PostService();
    }

    public void registPost() {
        System.out.println("===== 게시물 등록 =====");

        Scanner sc = new Scanner(System.in);

        System.out.print("제목을 입력하세요: ");
        String title = sc.nextLine();

        System.out.print("내용을 입력하세요: ");
        String content = sc.nextLine();

        CreatePostDto requestDto = new CreatePostDto(title, content);

        int result = postService.registPost(requestDto);

        if (result >= 1) {
            System.out.println("게시물 성공적으로 등록되었습니다.");
        } else {
            System.out.println("게시물 등록에 실패했습니다.");
        }
    }
}