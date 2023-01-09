package com.sparta.hanghaeblog.controller;


import com.sparta.hanghaeblog.dto.BlogRequestDto;
import com.sparta.hanghaeblog.dto.BlogResponseDto;
import com.sparta.hanghaeblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/")
    public ModelAndView home() {
        return new ModelAndView("index");
    }

    @PostMapping("/api/blogs")
    public BlogResponseDto createBlog(@RequestBody BlogRequestDto requestDto, HttpServletRequest request) {
        return blogService.createBlog(requestDto, request);
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
    public BlogResponseDto updateBlog(@PathVariable Long id, @RequestBody BlogRequestDto requestDto, HttpServletRequest request) {
        return blogService.update(id, requestDto, request);
    }

    @DeleteMapping("/api/blogs/{id}")
    public String deleteBlog(@PathVariable Long id, HttpServletRequest request) {
        return blogService.deleteBlog(id, request);

    }
}