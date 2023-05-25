package com.ssafy.trip.exception;

public class TooManyRequestException extends RuntimeException {
    public TooManyRequestException() {
        super("요청 수가 너무 많습니다.");
    }
}