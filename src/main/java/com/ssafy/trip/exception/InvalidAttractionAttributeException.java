package com.ssafy.trip.exception;

public class InvalidAttractionAttributeException extends Exception {

    public InvalidAttractionAttributeException() {
        super("관광지 검색 도중 에러가 발생하였습니다.");
    }
}
