package com.example.reactappbackend.utils.interceptor;

import com.example.reactappbackend.utils.JwtUtils;
import com.example.reactappbackend.utils.TokenStatus;
import org.apache.logging.log4j.util.Strings;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
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
        String token = request.getHeader("token");
        String refreshToken = request.getHeader("refresh-token");
        TokenStatus tokenStatus = JwtUtils.statusToken(token);
//        switch (tokenStatus) {
//            case VALID:
//                System.out.println("검증됨");
//                return true;
//            case NONE:
//                System.out.println("토큰 없음");
//                return false;
//            case EXPIRED:
//                System.out.println("만료됨, 재발급 요청");
//                if(StringUtils.hasText(refreshToken)) {
//                    // DB 에서 refresh token 을 뽑아옴
//
//                    // DB에서 refresh token 뽑아온 값이 클라이언트쪽이랑 같고,
//                    // refresh token 검증 되고,
//                    // response가 null이 아니면 재발급 후 header 에 담아서 api 호출
//                    if(JwtUtils.statusToken(refreshToken).equals(TokenStatus.VALID) && response != null) {
//                        response.setHeader("token", JwtUtils.refreshAccessToken(token));
//                        return true;
//                    }
//                }
//                return false;
//        }
        return true;
    }
}
