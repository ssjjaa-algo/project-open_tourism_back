package com.ssafy.trip.exception;

public class NoBoardContentException extends RuntimeException {

    private static final String msg = "내용을 작성해주세요.";
    public NoBoardContentException() {
        super(msg);
    }

    public NoBoardContentException(String message) {
        super(message);
    }
}
