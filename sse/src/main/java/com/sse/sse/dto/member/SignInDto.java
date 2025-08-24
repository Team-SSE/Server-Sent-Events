package com.sse.sse.dto.member;

public class SignInDto {
    private String email;
    private String password;

    public SignInDto() {
    }

    public SignInDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
