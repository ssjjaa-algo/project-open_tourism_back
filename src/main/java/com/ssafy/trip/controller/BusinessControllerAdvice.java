package com.ssafy.trip.controller;

import com.ssafy.trip.exception.ErrorResponse;
import com.ssafy.trip.exception.InvalidAttractionAttributeException;
import org.springframework.boot.context.properties.bind.BindException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BusinessControllerAdvice {

    /**
     * 422번 에러 반환
     * 유저가 강제로 잘못된 입력을 담아 주는 것이므로
     */
    @ExceptionHandler(InvalidAttractionAttributeException.class)
    protected ResponseEntity<ErrorResponse> handleInvalidAttractionAttributeException(BindException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
