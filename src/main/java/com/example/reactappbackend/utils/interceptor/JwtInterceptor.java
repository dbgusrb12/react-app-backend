package com.example.reactappbackend.utils.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // Access token이 유효하면 true
        // 유효하지 않으면
        // refresh token 검사
        // 유효하면 재발급 하고 true
        // 유효하지 않으면 false
        // 토큰이 없으면 false

        return true;
    }
}
