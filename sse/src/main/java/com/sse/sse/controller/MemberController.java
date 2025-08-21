package com.sse.sse.controller;

import com.sse.sse.dto.member.SignupDto;
import com.sse.sse.service.MemberService;

import java.util.Scanner;

public class MemberController {
    private static final MemberService memberService = new MemberService();
    public void signup() {
        Scanner sc = new Scanner(System.in);

        System.out.println("어서오세요. 회원 가입을 진행합니다!");

        String email = "";
        while(true) {
            System.out.print("이메일 입력: ");
            email = sc.nextLine();
            if (!memberService.isDuplicateEmail(email)) break;
            System.out.println("중복된 이메일입니다.");
        }

        System.out.print("비밀번호 입력: ");
        String password = sc.nextLine();

        System.out.print("닉네임 입력: ");
        String nickname = sc.nextLine();

        SignupDto dto = new SignupDto(email, password, nickname);

        if (memberService.signup(dto) > 0) {
            System.out.println("환영합니다! 성공적으로 회원 가입되었습니다.");
        } else {
            System.out.println("회원 가입에 실패하였습니다.");
        }
    }
}
