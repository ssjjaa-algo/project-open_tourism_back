package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.InvalidRegistException;
import com.ssafy.trip.exception.MaliciousAccessException;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class MemberDuplicateNameRequestDto {

    private String userName;

    public MemberDuplicateNameRequestDto() {
    }

    public MemberDuplicateNameRequestDto(String userName) {
        setUserId(userName);
    }


    private static final String USERNAME_REG = "^[a-zA-Z0-9]{2,8}$";
    private static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REG);

    public void setUserId(String userName) {

        if (!USERNAME_PATTERN.matcher(userName).matches())
            throw new MaliciousAccessException();

        if (userName.length() < 2 || userName.length() > 8)
            throw new MaliciousAccessException();

        this.userName = userName;
    }
}
