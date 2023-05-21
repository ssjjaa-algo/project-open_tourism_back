package com.ssafy.trip.domain.member;

import com.ssafy.trip.exception.InvalidRegistException;

import java.util.regex.Pattern;

public class UserEmail {


    private String userEmail;

    public UserEmail(String userEmail) {
        validation(userEmail);
        this.userEmail = userEmail;
    }

    private void validation(final String userEmail) {
        if (!USEREMAIL_PATTERN.matcher(userEmail).matches()) {
            throw new InvalidRegistException("이메일 형식이 맞지 않습니다.");
        }
    }

}
