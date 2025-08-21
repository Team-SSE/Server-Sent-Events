package com.sse.sse.dto.member;

public class SignupDto {
    private String email;
    private String password;
    private String nickname;

    public SignupDto() {
    }

    public SignupDto(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }
}
