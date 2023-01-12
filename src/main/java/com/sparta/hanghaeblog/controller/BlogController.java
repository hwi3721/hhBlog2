package com.sparta.hanghaeblog.controller;


import com.sparta.hanghaeblog.dto.BlogRequestDto;
import com.sparta.hanghaeblog.dto.BlogResponseDto;
import com.sparta.hanghaeblog.dto.OkMessage;
import com.sparta.hanghaeblog.security.UserDetailsImpl;
import com.sparta.hanghaeblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/blogs")
    public ResponseEntity<Object> createBlog(@RequestBody BlogRequestDto requestDto,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails) {
        return new ResponseEntity<>(blogService.createBlog(requestDto, userDetails.getUser()), OK);
    }

    @GetMapping("/api/blogs")
    public List<BlogResponseDto> getBlogs() {
        return blogService.getBlogs();
    }

    @GetMapping("/api/blogs/{id}")
    public BlogResponseDto getBlog(@PathVariable Long id) {
        return blogService.getBlog(id);
    }

    @PatchMapping("/api/blogs/{id}")
    public ResponseEntity<Object> updateBlog(@PathVariable Long id,
                                             @RequestBody BlogRequestDto requestDto,
                                             @AuthenticationPrincipal UserDetailsImpl userDetails) throws IllegalAccessException {
        OkMessage message = blogService.update(id, requestDto, userDetails.getUser());
        return new ResponseEntity<>(message, message.getStatus());
    }


    @DeleteMapping("/api/blogs/{id}")
    public ResponseEntity<Object> deleteBlog(@PathVariable Long id,
                             @AuthenticationPrincipal UserDetailsImpl userDetails)
            throws IllegalAccessException {
        OkMessage okMessage = blogService.delete(id, userDetails.getUser());
        return new ResponseEntity<>(okMessage, OK);

    }
}