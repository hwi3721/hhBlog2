package com.sparta.hanghaeblog.controller;

import com.sparta.hanghaeblog.dto.JoinRequestDto;
import com.sparta.hanghaeblog.dto.LoginRequestDto;
import com.sparta.hanghaeblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

//    @GetMapping("/join")
//    public ModelAndView joinPage() {
//        return new ModelAndView("join");
//    }
//
//    @GetMapping("/login")
//    public ModelAndView loginPage() {
//        return new ModelAndView("login");
//    }

    @PostMapping("/join")
    public ResponseEntity<AuthMessage> signup(@RequestBody @Valid JoinRequestDto joinRequestDto) {
        userService.signup(joinRequestDto);
        AuthMessage authMessage = new AuthMessage("회원가입 성공", OK.value());
        return new ResponseEntity<>(authMessage, OK);

    }

    @ResponseBody
    @PostMapping("/login")
    public ResponseEntity<AuthMessage> login(@RequestBody LoginRequestDto loginRequestDto,
                        HttpServletResponse response) {
        userService.login(loginRequestDto, response);

        AuthMessage authMessage = new AuthMessage("로그인 성공", OK.value());
        return new ResponseEntity<>(authMessage, OK);
    }
}
