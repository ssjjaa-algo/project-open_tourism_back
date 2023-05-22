package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.InvalidRegistException;
import lombok.Getter;

import java.util.regex.Pattern;

@Getter
public class MemberDuplicateIdRequestDto {

    private String userId;

    public MemberDuplicateIdRequestDto() {
    }

    public MemberDuplicateIdRequestDto(String userId) {
        setUserId(userId);
    }


    private static final String USERID_REG = "^(?=.*[a-zA-Z]|.*\\d)[a-zA-Z\\d]{5,10}$";
    private static final Pattern USERID_PATTERN = Pattern.compile(USERID_REG);

    public void setUserId(String userId) {

        if (!USERID_PATTERN.matcher(userId).matches())
            throw new InvalidRegistException("id가 형식에 맞지 않습니다.");

        if (userId.length() < 5 || userId.length() > 10)
            throw new InvalidRegistException("id의 길이는 5 이상 10 이하.");

        this.userId = userId;
    }
}
