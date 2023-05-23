package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.InvalidRegistException;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class MemberDuplicateEmailRequestDto {

    private String userEmail;

    public MemberDuplicateEmailRequestDto() {
    }

    public MemberDuplicateEmailRequestDto(String userEmail) {
        setUserId(userEmail);
    }


    private static final String USEREMAIL_REG = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern USEREMAIL_PATTERN = Pattern.compile(USEREMAIL_REG);

    public void setUserId(String userEmail) {

        if (!USEREMAIL_PATTERN.matcher(userEmail).matches())
            throw new InvalidRegistException("email이 형식에 맞지 않습니다.");

        this.userEmail = userEmail;
    }
}
