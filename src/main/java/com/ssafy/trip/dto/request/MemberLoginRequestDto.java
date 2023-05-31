package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.MaliciousAccessException;
import lombok.Getter;
import lombok.NonNull;

import java.util.regex.Pattern;

@Getter
public class MemberLoginRequestDto {

    @NonNull
    private String userId;
    @NonNull
    private String userPwd;


    public MemberLoginRequestDto() {
    }

    public MemberLoginRequestDto(@NonNull String userId, @NonNull String userPwd) {
        setUserId(userId);
        setUserPwd(userPwd);
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }



    public void setUserPwd(String userPwd) {

        this.userPwd = userPwd;
    }
}
