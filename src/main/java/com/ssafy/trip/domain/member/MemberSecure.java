package com.ssafy.trip.domain.member;

import com.ssafy.trip.exception.InvalidRegistException;
import lombok.Getter;
import lombok.NonNull;

@Getter
public class MemberSecure {

    @NonNull
    private String userId;
    @NonNull
    private String salt;

    public MemberSecure(@NonNull String userId, @NonNull String salt) {
        setUserid(userId);
        setSalt(salt);
    }

    public void setUserid(String userId) {
        if (userId.length() < 5 || userId.length() > 10) {
            throw new InvalidRegistException("유효하지 않은 id값 삽입시도, hacker?");
        }
        this.userId = userId;
    }

    public void setSalt(String salt) {
        // salt 예외처리 전략
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "MemberSecure{" +
                "userid='" + userId + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
