package com.assignment.week9assignment.controller;

import com.assignment.week9assignment.dto.LoginDto;
import com.assignment.week9assignment.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;


    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto){
        return loginService.login(loginDto);
    }

}
