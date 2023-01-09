package com.sparta.hanghaeblog.service;


import com.sparta.hanghaeblog.dto.BlogRequestDto;
import com.sparta.hanghaeblog.dto.BlogResponseDto;
import com.sparta.hanghaeblog.entity.Blog;
import com.sparta.hanghaeblog.entity.User;
import com.sparta.hanghaeblog.jwt.JwtUtil;
import com.sparta.hanghaeblog.repository.BlogRepository;
import com.sparta.hanghaeblog.repository.UserRepository;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    //    @Transactional
    public BlogResponseDto createBlog(BlogRequestDto requestDto, HttpServletRequest request) {
        // Request에서 Token 가져오기
        String token = jwtUtil.resolveToken(request);
        Claims claims;

        // 토큰이 있는 경우에만 동작할거야
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
            );
            Blog blog = new Blog(requestDto, user);
            blogRepository.save(blog);

            return new BlogResponseDto(blog);
        }
        return null;
    }

//    @Transactional(readOnly = true)
//    public List<Memo> getMemos() {
//        return memoRepository.findAllByOrderByCreatedAtDesc();
//    }

    //    @Transactional(readOnly = true)
    public List<BlogResponseDto> getBlogs() {
        List<BlogResponseDto> blogResponseDtos = new ArrayList<>();
        try {
            List<Blog> blogs = blogRepository.findAllByOrderByCreatedAtDesc();
            for (Blog blog : blogs) {
                if (blog.getIsDeleted() == null) {
                    BlogResponseDto blogResponseDto = new BlogResponseDto(blog);
                    blogResponseDtos.add(blogResponseDto);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();   // 예외가 어디서 어떻게 생기는지 보여주라 !
        }
        return blogResponseDtos;
    }

    //    @Transactional(readOnly = true)
//    public List<NewDto> getMemos() {
//        List<NewDto> newDtos = new ArrayList<>();
//        try {
//            List<Blog> blogs = blogRepository.findAllByOrderByCreatedAtDesc();
//            for (int i = 0; i < blogs.size(); i++) {
//                newDtos.add(new NewDto(blogs.get(i)));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();   //예외가 어디서 어떻게 생겼는 지 알려줌
//        }
//        return newDtos;
//    }
    @Transactional
    public BlogResponseDto getBlog(Long id) {
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (blog.getIsDeleted() != null) {
            throw new IllegalArgumentException("존재하지 않는 게시글입니다.");
        }


        return new BlogResponseDto(blog);
    }

    @Transactional
    public BlogResponseDto update(Long id, BlogRequestDto requestDto, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        // 토큰이 있는 경우에만 동작할거야
        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
//            User user = userRepository.findByUsername(claims.getSubject()).orElseThrow(
//                    () -> new IllegalArgumentException("사용자가 존재하지 않습니다.")
//            );
            if(!jwtUtil.getUserInfoFromToken(token).getSubject().equals(blog.getUsername())) {
                throw new IllegalArgumentException("게시물 작성자가 아닙니다.");
            }
        }blog.update(requestDto);

        return new BlogResponseDto(blog);
    }

    @Transactional
    public String deleteBlog(Long id, HttpServletRequest request) {
        String token = jwtUtil.resolveToken(request);
        Claims claims;
        Blog blog = blogRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        if (token != null) {
            if (jwtUtil.validateToken(token)) {
                // 토큰에서 사용자 정보 가져오기
                claims = jwtUtil.getUserInfoFromToken(token);
            } else {
                throw new IllegalArgumentException("Token Error");
            }

            // 토큰에서 가져온 사용자 정보를 사용하여 DB 조회
            if(!jwtUtil.getUserInfoFromToken(token).getSubject().equals(blog.getUsername())) {
                throw new IllegalArgumentException("게시물 작성자가 아닙니다.");
            }
        }
        blog.softDelete(true);
        return "삭제되었습니다.";
    }
}