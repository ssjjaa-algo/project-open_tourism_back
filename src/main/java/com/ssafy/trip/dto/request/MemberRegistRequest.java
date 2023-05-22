package com.ssafy.trip.dto.request;

import com.ssafy.trip.exception.InvalidRegistException;
import lombok.Getter;
import lombok.NonNull;

import java.util.regex.Pattern;

@Getter
public class MemberRegistRequest {

    // @NonNull
    private String userId;
    @NonNull
    private String userPwd;
    @NonNull
    private String userName;
    @NonNull
    private String userEmail;

    public MemberRegistRequest() {

    }
    public MemberRegistRequest(@NonNull String userId, @NonNull String userPwd, @NonNull String userName, @NonNull String userEmail) {
        this.userId = userId;
        validation(userPwd);
        this.userPwd = userPwd;
        this.userName = userName;
        this.userEmail = userEmail;

    }

    public static final int USERPWD_MIN_LENGTH = 8;
    public static final int USERPWD_MAX_LENGTH = 15;
    public static final String USERPWD_REG = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).{8,15}$";
    private static final Pattern USERPWD_PATTERN = Pattern.compile(USERPWD_REG);

    private void validation(final String userPwd) {

        if (userPwd.length() < USERPWD_MIN_LENGTH || userPwd.length() > USERPWD_MAX_LENGTH) {
            throw new InvalidRegistException("비밀번호는 8자리 이상 15자리 이하입니다.");
        }

        if (!USERPWD_PATTERN.matcher(userPwd).matches()) {
            throw new InvalidRegistException("비밀번호는 영문, 숫자, 특수문자를 포함하여야 합니다.");
        }

    }

}
