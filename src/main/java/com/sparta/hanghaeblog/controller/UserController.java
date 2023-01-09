package com.sparta.hanghaeblog.controller;

import com.sparta.hanghaeblog.dto.JoinRequestDto;
import com.sparta.hanghaeblog.dto.LoginRequestDto;
import com.sparta.hanghaeblog.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/join")
    public ModelAndView joinPage() {
        return new ModelAndView("join");
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/join")
    public String signup(@RequestBody JoinRequestDto joinRequestDto) {
        userService.signup(joinRequestDto);
        return "redirect:/api/user/login";
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return "success";
    }
}
