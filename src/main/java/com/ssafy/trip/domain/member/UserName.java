//package com.ssafy.trip.domain.member;
//
//import com.ssafy.trip.exception.InvalidRegistException;
//
//import java.util.regex.Pattern;
//
//public class UserName {
//    public static final int USERNAME_MIN_LENGTH = 2;
//    public static final int USERNAME_MAX_LENGTH = 8;
//
//
//    private String userName;
//
//    public UserName(String userName) {
//        validation(userName);
//        this.userName=userName;
//    }
//
//    private void validation(final String userName) {
//
//        if (userName.length() < USERNAME_MIN_LENGTH || userName.length() > USERNAME_MAX_LENGTH) {
//            throw new InvalidRegistException("닉네임은 2자리 이상 8자리 이하입니다.");
//        }
//
//        if (!USERNAME_PATTERN.matcher(userName).matches()) {
//            throw new InvalidRegistException("닉네임은 영어와 숫자만 입력 가능합니다");
//        }
//    }
//}
