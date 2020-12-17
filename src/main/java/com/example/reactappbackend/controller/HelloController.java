package com.example.reactappbackend.controller;

import com.example.reactappbackend.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return JwtUtils.createToken("dbgusrb12@gmail.com", "유현규");
    }
}
