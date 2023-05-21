package com.ssafy.trip.domain.member;

import com.ssafy.trip.exception.InvalidRegistException;

import java.util.regex.Pattern;

public class UserId {

    public static final int MIN_ID_LENGTH = 5;
    public static final int MAX_ID_LENGTH = 10;


    private String userId;

    public UserId(String userId) {
        validation(userId);
        this.userId = userId;
    }

    private void validation(final String userId) {

    }
}
