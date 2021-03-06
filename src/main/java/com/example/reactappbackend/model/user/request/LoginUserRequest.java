package com.example.reactappbackend.model.user.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class LoginUserRequest {
    @NotBlank(message = "이메일을 입력해주세요.")
    @Email(message = "이메일 형식으로 작성해 주세요.")
    private String email;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
}
