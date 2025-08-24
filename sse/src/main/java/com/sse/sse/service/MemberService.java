package com.sse.sse.service;

import com.sse.sse.aggregate.Member;
import com.sse.sse.aggregate.enums.MemberStatus;
import com.sse.sse.dto.member.SignInDto;
import com.sse.sse.dto.member.SignupDto;
import com.sse.sse.repository.MemberRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class MemberService {
    private final MemberRepository memberRepository = new MemberRepository();

    public Long getMemberId(final String inputEmail) {
        ArrayList<Member> memberList = memberRepository.findAllMembers();
        for (Member member : memberList) {
            if(member.getEmail().equals(inputEmail)) {
                return member.getId();
            }
        }
        return -1L;
    }

    public int signup(final SignupDto dto) {
        Long newMemberId = memberRepository.getLastMemberId() + 1;
        Member newMember = new Member(
                newMemberId,
                dto.getEmail(),
                dto.getPassword(),
                dto.getNickname(),
                true,
                MemberStatus.ACTIVE
        );
        return memberRepository.signup(newMember);
    }

    public Long signIn(final SignInDto dto) {
        Long result = -1L;

        ArrayList<Member> memberList = memberRepository.findAllMembers();
        for (Member member : memberList) {
            if(member.getEmail().equals(dto.getEmail()) && member.getPassword().equals(dto.getPassword())) {
                result = getMemberId(dto.getEmail());
            }
        }

        return result;
    }

    public void putSignedInMember(final Long attemptMemberId) {
        memberRepository.putSignedInMember(attemptMemberId);
    }

    public boolean signOut(final String email) {
        Long memberId = getMemberId(email);

        if(memberId > 0) {
            if(memberRepository.getSignedInTime(memberId) != null) {
                memberRepository.removeSignedInMember(memberId);
                return true;
            }
        }

        return false;
    }
}
