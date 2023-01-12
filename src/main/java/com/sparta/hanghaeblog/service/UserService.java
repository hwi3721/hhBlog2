package com.sparta.hanghaeblog.service;

import com.sparta.hanghaeblog.dto.JoinRequestDto;
import com.sparta.hanghaeblog.dto.LoginRequestDto;
import com.sparta.hanghaeblog.entity.User;
import com.sparta.hanghaeblog.entity.UserRoleEnum;
import com.sparta.hanghaeblog.jwt.JwtUtil;
import com.sparta.hanghaeblog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private static final String ADMIN_TOKEN = "AAABnvxRVklrnYxKZ0aHgTBcXukeZygoC";
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final com.sparta.hanghaeblog.jwt.JwtUtil jwtUtil;


    @Transactional
    public void signup(JoinRequestDto joinRequestDto) {
        String username = joinRequestDto.getUsername();
        String password = passwordEncoder.encode(joinRequestDto.getPassword());

        if (userRepository.findByUsername(username).isPresent()){
            throw new IllegalArgumentException("username이 중복됩니다.");
        }

        UserRoleEnum role = UserRoleEnum.USER;
        if (joinRequestDto.isAdmin()){
            if (!joinRequestDto.getAdminToken().equals(ADMIN_TOKEN)){
                throw new IllegalArgumentException("등록 불가 : 관리자 암호가 틀립니다.");
            }
            role = UserRoleEnum.ADMIN;
        }

        User user = new User(username, password, role);
        userRepository.save(user);
    }

    public void login(LoginRequestDto loginRequestDto, HttpServletResponse response) {
        String username = loginRequestDto.getUsername();
        String password = loginRequestDto.getPassword();

        // 사용자 확인
        User user = userRepository.findByUsername(username).orElseThrow(
                ()-> new IllegalArgumentException("등록된 사용자가 없습니다.")
        );
        // 비밀번호 확인
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        response.addHeader(JwtUtil.AUTHORIZATION_HEADER,
                jwtUtil.createToken(user.getUsername(),user.getRole()));
    }
}