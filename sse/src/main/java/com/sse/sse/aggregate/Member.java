package com.sse.sse.aggregate;

import com.sse.sse.aggregate.enums.MemberStatus;

public class Member {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private boolean notificationStatus;
    private MemberStatus memberStatus;

    public Member() {
    }
}