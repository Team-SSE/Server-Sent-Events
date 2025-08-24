package com.sse.sse.common;

import java.util.Scanner;

public class MyUtil {
    public static String checkInputText(String target, String inputMessage) {
        Scanner sc = new Scanner(System.in);
        String input = "";

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
