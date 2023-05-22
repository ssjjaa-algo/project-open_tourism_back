package com.ssafy.trip.exception;

public class InvalidBoardRequestException extends BusinessException {
    public InvalidBoardRequestException(String message) {
        super(message);
    }
}
