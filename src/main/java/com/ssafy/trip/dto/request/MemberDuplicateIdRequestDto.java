package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.InvalidRegistException;
import lombok.Getter;

@Getter
public class MemberDuplicateIdRequestDto {

    private String userId;

    public MemberDuplicateIdRequestDto() {
    }

    public MemberDuplicateIdRequestDto(String userId) {
        setUserId(userId);
    }

    public void setUserId(String userId) {

        if (userId.length() < 5 || userId.length() > 10)
            throw new InvalidRegistException("유효하지 않은 id값입니다.");

        // 아이디 정규표현식 검사 추가 필요

        this.userId = userId;
    }
}
