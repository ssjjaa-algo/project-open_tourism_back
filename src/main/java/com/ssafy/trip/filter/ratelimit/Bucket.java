package com.ssafy.trip.filter.ratelimit;

import lombok.Getter;
import lombok.Setter;


@Getter
public class Bucket {
    long numberOfToken;
    long lastAccess;

    public Bucket(long numberOfToken, long lastAccess) {
        this.numberOfToken = numberOfToken;
        this.lastAccess = lastAccess;
    }

    public void setNumberOfToken(long numberOfToken) {
        if(numberOfToken<0) throw new RuntimeException("원인을 알 수 없는 에러가 발생했습니다.");
        this.numberOfToken = numberOfToken;
    }

    public void setLastAccess(long lastAccess) {
        if(numberOfToken<0) throw new RuntimeException("원인을 알 수 없는 에러가 발생했습니다.");
        this.lastAccess = lastAccess;
    }
}
