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
        System.out.println("게시물 등록을 시작합니다.");

        Scanner sc = new Scanner(System.in);

        String title = inputText("게시물 제목을 입력해주세요: ");
        String content = inputText("게시물 내용을 입력해주세요: ");

        CreatePostDto requestDto = new CreatePostDto(title, content);

        int result = postService.registPost(requestDto);

        if (result >= 1) {
            System.out.println("게시물 성공적으로 등록되었습니다!");
        } else {
            System.out.println("게시물 등록에 실패했습니다. 다시 시도해주세요.");
        }
    }

    private String inputText(String message) {
        Scanner sc = new Scanner(System.in);
        String input = null;

        while (true) {
            System.out.print(message);
            input = sc.nextLine();

            if (input.trim().length() != 0) {
                break;
            }

            System.out.println("입력되지 않았습니다. 다시 입력해주세요.");
        }

        return input;
    }
}