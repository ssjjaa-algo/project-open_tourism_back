package com.ssafy.trip.exception;

public class MaliciousAccessException extends BusinessException {

    public MaliciousAccessException() {
        super("스니핑 등의 악의적인 접근 제한");
    }

    public MaliciousAccessException(String msg) {
        super(msg);
    }
}
