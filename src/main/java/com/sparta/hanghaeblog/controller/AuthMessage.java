package com.sparta.hanghaeblog.controller;

import lombok.Getter;

@Getter
public class AuthMessage {
    private String msg;
    private Integer httpStatus;

    public AuthMessage(String msg, Integer httpStatus){
        this.msg = msg;
        this.httpStatus = httpStatus;
    }
}
