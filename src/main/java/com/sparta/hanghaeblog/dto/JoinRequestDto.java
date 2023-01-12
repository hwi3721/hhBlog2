package com.sparta.hanghaeblog.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter
@Setter
public class JoinRequestDto {

    @Size(min=4,max=10)
    //@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]")   //  (?=.*[a-z])
    private String username;

    @Size(min = 8, max = 15)
    //@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]")
    private String password;

    private boolean admin;

    private String adminToken;
}
