package com.ssafy.trip.interceptor;

import com.ssafy.trip.exception.MaliciousAccessException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession(false);
        System.out.println(session);
        //로그인 안된 유저
        if(session==null) {
            throw new MaliciousAccessException();
        }

        //차후 csrf 관련 로직 추가 필요

        //로그인 된 유저
        return true;
    }
}
