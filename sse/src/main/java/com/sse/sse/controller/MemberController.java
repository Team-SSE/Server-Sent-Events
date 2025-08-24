package com.sse.sse.controller;

import com.sse.sse.common.MyUtil;
import com.sse.sse.dto.member.SignInDto;
import com.sse.sse.dto.member.SignupDto;
import com.sse.sse.service.MemberService;

public class MemberController {
    private static final MemberService memberService = new MemberService();
    public void signup() {
        System.out.println("회원가입을 시작합니다.");

        String email = "";
        while(true) {
            email = MyUtil.checkInputText("이메일", "이메일을 입력해주세요: ");
            if (memberService.getMemberId(email) < 0) break;
            System.out.println("중복된 이메일입니다.");
        }
        String password = MyUtil.checkInputText("비밀번호", "비밀번호를 입력해주세요: ");
        String nickname = MyUtil.checkInputText("닉네임", "닉네임을 입력해주세요: ");

        SignupDto dto = new SignupDto(email, password, nickname);

        if (memberService.signup(dto) > 0) {
            System.out.println("환영합니다! 성공적으로 회원 가입되었습니다.");
        } else {
            System.out.println("회원 가입에 실패하였습니다.");
        }
    }

    public void signIn() {
        System.out.println("로그인을 시작합니다.");

        String email = MyUtil.checkInputText("이메일", "이메일을 입력해주세요: ");
        String password = MyUtil.checkInputText("비밀번호", "비밀번호를 입력해주세요: ");

        SignInDto dto = new SignInDto(email, password);
        Long attemptMemberId = memberService.signIn(dto);

        if (attemptMemberId > 0) {
            System.out.println("로그인에 성공하였습니다.");
            memberService.putSignedInMember(attemptMemberId);
        } else {
            System.out.println("로그인에 실패하였습니다. 아이디/비밀번호를 다시 확인해주세요");
        }
    }

}
