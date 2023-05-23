package com.ssafy.trip.dto.response;

import lombok.Getter;

@Getter
public class MemberLoginResponseDto {

    private String userId;
    private String userName;

    public MemberLoginResponseDto() {
    }

    public MemberLoginResponseDto(String userId, String userName) {
        setUserId(userId);
        setUserName(userName);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
