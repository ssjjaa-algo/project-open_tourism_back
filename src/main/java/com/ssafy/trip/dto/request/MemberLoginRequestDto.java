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


    private static final String USERID_REG = "^(?=.*[a-zA-Z]|.*\\d)[a-zA-Z\\d]{5,10}$";
    private static final Pattern USERID_PATTERN = Pattern.compile(USERID_REG);

    public static final String USERPWD_REG = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).{8,15}$";
    private static final Pattern USERPWD_PATTERN = Pattern.compile(USERPWD_REG);


    public MemberLoginRequestDto() {
    }

    public MemberLoginRequestDto(@NonNull String userId, @NonNull String userPwd) {
        setUserId(userId);
        setUserPwd(userPwd);
    }

    public void setUserId(String userId) {
        if (!USERID_PATTERN.matcher(userId).matches()) {
            throw new MaliciousAccessException();
        }
        if (userId.length() < 5 || userId.length() > 10) {
            throw new MaliciousAccessException();
        }
        this.userId = userId;
    }



    public void setUserPwd(String userPwd) {

        if(!USERPWD_PATTERN.matcher(userPwd).matches()) {
            throw new MaliciousAccessException();
        }
        if (userPwd.length() < 8 || userPwd.length() > 15) {
            throw new MaliciousAccessException();
        }
        this.userPwd = userPwd;
    }
}
