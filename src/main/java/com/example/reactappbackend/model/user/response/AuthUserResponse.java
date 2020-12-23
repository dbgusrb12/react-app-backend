package com.example.reactappbackend.model.user.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthUserResponse {
    private int auth;   // 로그인 여부 판단 flag ( 0 = 로그인 안함, 1 = 일반 회원, 2 = 관리자 )
}
