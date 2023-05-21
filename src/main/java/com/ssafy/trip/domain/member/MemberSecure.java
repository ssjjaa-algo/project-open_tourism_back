package com.ssafy.trip.domain.member;

import lombok.Getter;
import lombok.NonNull;

@Getter
public class MemberSecure {

    @NonNull
    private String userid;
    @NonNull
    private String salt;

    public MemberSecure(@NonNull String userid, @NonNull String salt) {
        setUserid(userid);
        setSalt(salt);
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "MemberSecure{" +
                "userid='" + userid + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
