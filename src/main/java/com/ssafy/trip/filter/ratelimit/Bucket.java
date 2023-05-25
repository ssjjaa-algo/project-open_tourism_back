package com.ssafy.trip.filter.ratelimit;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Bucket {
    long count;
    long lastAccess;

    public Bucket(long count, long lastAccess) {
        this.count = count;
        this.lastAccess = lastAccess;
    }
}