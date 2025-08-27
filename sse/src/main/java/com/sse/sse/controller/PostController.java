package com.sse.sse.controller;

import com.sse.sse.aggregate.Post;
import com.sse.sse.dto.request.PostRequestDto;
import com.sse.sse.dto.response.PostDetailResponseDto;
import com.sse.sse.dto.response.PostResponseDto;
import com.sse.sse.service.PostService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PostController {
    private final PostService postService;

    public PostController() {
        postService = new PostService();
    }

    public void registPost() {
        System.out.println("게시물 등록을 시작합니다.");

        final String title = inputText("제목", "제목을 입력해주세요: ");
        final String content = inputText("내용", "내용을 입력해주세요: ");

        final PostRequestDto requestDto = new PostRequestDto(title, content);

        // TODO null 대신 로그인한 회원으로 변경 필요
        final int result = postService.registPost(null, requestDto);

        if (result >= 1) {
            System.out.println("게시물 성공적으로 등록되었습니다!");
        } else {
            System.out.println("게시물 등록에 실패했습니다. 다시 시도해주세요.");
        }
    }

    public void findAllPosts() {
        System.out.println("등록된 게시물 목록입니다.");

        final List<PostResponseDto> responseDto = postService.findAllPosts().stream()
                .map(PostResponseDto::of)
                .collect(Collectors.toList());

        if (responseDto.isEmpty()) {
            System.out.println("아직 등록된 게시물이 없습니다.");
        } else {
            responseDto.forEach(System.out::println);
        }
    }

    public void findPostById() {
        Scanner sc = new Scanner(System.in);

        System.out.print("조회할 게시물의 ID를 입력하세요: ");

        try {
            final long input = sc.nextLong();

            final Optional<Post> post = postService.findPostById(input);

            if (post.isPresent()) {
                System.out.println(PostDetailResponseDto.of(post.get()));
            } else {
                System.out.println("해당 ID의 게시물을 찾을 수 없습니다.");
            }
        } catch (Exception e) {
            System.out.println("게시물 조회 중 오류가 발생했습니다. 입력 값을 확인하거나 다시 시도해 주세요.");
        }
    }

    public void removePost() {
        Scanner sc = new Scanner(System.in);

        // TODO 로그인 여부 확인 및 로그인한 사용자가 작성한 게시물인지 확인
        System.out.print("삭제할 게시물의 ID를 입력해주세요: ");

        try {
            final long postId = sc.nextLong();

            final Optional<Post> post = postService.findPostById(postId);

            if (post.isPresent()) {
                int result = postService.removePost(post.get());

                System.out.println((result == 1) ? "게시물 성공적으로 삭제되었습니다." : "게시물 삭제에 실패했습니다. 다시 시도해주세요.");
            } else {
                System.out.println("해당 ID의 게시물을 찾을 수 없습니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("게시물 삭제 중 오류가 발생했습니다. 입력 값을 확인하거나 다시 시도해 주세요.");
        }
    }

    public void modifyPost() {
        Scanner sc = new Scanner(System.in);

        // TODO 로그인 여부 확인 및 로그인한 사용자가 작성한 게시물인지 확인
        System.out.print("수정할 게시물의 ID를 입력해주세요: ");

        try {
            final long postId = sc.nextLong();

            final Optional<Post> post = postService.findPostById(postId);

            if (post.isPresent()) {
                System.out.println("1. 제목만 수정");
                System.out.println("2. 내용만 수정");
                System.out.println("3. 제목과 내용 모두 수정");
                System.out.println("4. 이전 메뉴로 돌아가기");

                System.out.print("원하는 작업을 선택하세요: ");

                final int input = sc.nextInt();

                sc.nextLine();

                String title = null;
                String content = null;

                switch (input) {
                    case 1:
                        title = inputText("제목", "제목을 입력해주세요: ");
                        break;
                    case 2:
                        content = inputText("내용", "내용을 입력해주세요: ");
                        break;
                    case 3:
                        title = inputText("제목", "제목을 입력해주세요: ");
                        content = inputText("내용", "내용을 입력해주세요: ");
                        break;
                    case 4:
                        System.out.println("게시물 수정을 취소하고 이전 메뉴로 돌아갑니다.");
                        return;
                    default:
                        System.out.println("잘못된 입력입니다. 게시물 수정을 종료합니다.");
                        return;
                }

                final int result = postService.modifyPost(post.get(), new PostRequestDto(title, content));

                System.out.println((result == 1) ? "게시물 성공적으로 수정되었습니다." : "게시물 수정에 실패했습니다. 다시 시도해주세요.");
            } else {
                System.out.println("입력하신 ID의 게시물을 찾을 수 없습니다.");
            }
        } catch (InputMismatchException e) {
            System.out.println("게시물 수정 중 오류가 발생했습니다. 입력 값을 확인하거나 다시 시도해 주세요.");
        }
    }

    private String inputText(final String target, final String inputMessage) {
        Scanner sc = new Scanner(System.in);
        String input = null;

        while (true) {
            System.out.print(inputMessage);
            input = sc.nextLine();

            if (input.trim().length() != 0) {
                break;
            }

            System.out.println(target + "(이)가 입력되지 않았습니다. 다시 입력해주세요.");
        }

        return input;
    }
}