package com.ssafy.trip.domain.member;

import com.ssafy.trip.exception.BusinessException;
import com.ssafy.trip.exception.InvalidRegistException;
import lombok.Getter;
import lombok.NonNull;

import java.util.regex.Pattern;

@Getter
public class Member {

    @NonNull
    private String userId;

    private String userPwd; // 유효성
    @NonNull
    private String userName; // 유효성
    @NonNull
    private String userEmail; // 유효성
    private int countFail;
    private String refrshToken;

    // 유효성 검사 위한 userid, useremail, username 정규표현식
    // 얘를 다른 객체에 넣어놔가지고 import?
    private static final String USERID_REG = "^(?=.*[a-zA-Z]|.*\\d)[a-zA-Z\\d]{5,10}$";
    private static final Pattern USERID_PATTERN = Pattern.compile(USERID_REG);

    private static final String USEREMAIL_REG = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    private static final Pattern USEREMAIL_PATTERN = Pattern.compile(USEREMAIL_REG);

    private static final String USERNAME_REG = "^[a-zA-Z0-9]{2,8}$";
    private static final Pattern USERNAME_PATTERN = Pattern.compile(USERNAME_REG);


    public Member() {

    }


    public Member(String userId, String userName, String userEmail, int countFail) {
        setUserId(userId);
        setUserName(userName);
        setUserEmail(userEmail);
        setCountFail(countFail);
    }

    public Member(String userId,String userName, String userEmail, int countFail, String refrshToken) {
        setUserId(userId);
        setUserName(userName);
        setUserEmail(userEmail);
        setCountFail(countFail);
        setRefrshToken(refrshToken);
    }

    public void setUserId(String userId) {
        if (userId.length() < 5 || userId.length() > 10) {
            throw new InvalidRegistException("아이디는 5자 이상 10자 이하입니다.");
        }

        if (!USERID_PATTERN.matcher(userId).matches()) {
            throw new InvalidRegistException("아이디는 숫자와 영어만 포함해야 합니다.");
        }

        this.userId = userId;
    }

    public void setUserPwd(String userPwd) {
        if (userPwd.length() < 0 || userPwd.length() > 255) {
            throw new InvalidRegistException("유효하지 않은 비밀번호.");
        }
        this.userPwd=userPwd;
    }

    public void setUserName(String userName) {

        if (userName.length() < 2 || userName.length() > 8) {
            throw new InvalidRegistException("닉네임은 2자리 이상 8자리 이하입니다.");
        }

        if (!USERNAME_PATTERN.matcher(userName).matches()) {
            throw new InvalidRegistException("닉네임은 영어와 숫자만 입력 가능합니다");
        }

        this.userName = userName;
    }

    public void setUserEmail(String userEmail) {
        if (!USEREMAIL_PATTERN.matcher(userEmail).matches()) {
            throw new InvalidRegistException("이메일 형식이 맞지 않습니다.");
        }

        this.userEmail=userEmail;
    }

    public void setCountFail(int countFail) {
        if (countFail == 5) this.countFail = countFail;

        else throw new BusinessException("유효하지 않은 값을 의도? hacker?");
    }

    public void setRefrshToken(String refrshToken) {
        this.refrshToken = refrshToken;
    }
}
