package com.ssafy.trip.exception;

public class NoBoardSubjectException extends RuntimeException {
    private static final String msg = "제목을 작성해주세요";
    public NoBoardSubjectException() {
        super(msg);
    }

    public NoBoardSubjectException(String message) {
        super(message);
    }
}
