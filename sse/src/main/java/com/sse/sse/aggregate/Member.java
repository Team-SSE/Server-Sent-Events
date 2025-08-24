package com.sse.sse.aggregate;

import com.sse.sse.aggregate.enums.MemberStatus;

import java.io.Serializable;

public class Member implements Serializable {
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private boolean notificationStatus;
    private MemberStatus memberStatus;

    public Member() {
    }

    public Member(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public Member(Long id, String email, String password, String nickname, boolean notificationStatus, MemberStatus memberStatus) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.notificationStatus = notificationStatus;
        this.memberStatus = memberStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public boolean isNotificationStatus() {
        return notificationStatus;
    }

    public void setNotificationStatus(boolean notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public MemberStatus getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(MemberStatus memberStatus) {
        this.memberStatus = memberStatus;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", notificationStatus=" + notificationStatus +
                ", memberStatus=" + memberStatus +
                '}';
    }
}