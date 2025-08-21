package com.sse.sse;

import com.sse.sse.controller.MemberController;

public class Application {
    public static void main(String[] args) {
        MemberController controller = new MemberController();
        controller.signup();
    }
}