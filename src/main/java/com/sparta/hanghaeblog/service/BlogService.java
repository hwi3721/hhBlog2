package com.sparta.hanghaeblog.service;


import com.sparta.hanghaeblog.dto.BlogRequestDto;
import com.sparta.hanghaeblog.dto.BlogResponseDto;
import com.sparta.hanghaeblog.dto.OkMessage;
import com.sparta.hanghaeblog.entity.Blog;
import com.sparta.hanghaeblog.entity.User;
import com.sparta.hanghaeblog.entity.UserRoleEnum;
import com.sparta.hanghaeblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;


@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final static String ILLEGAL_ACCESS_MESSAGE = "작성자 혹은 관리자만 삭제/수정할 수 있습니다.";


    //    @Transactional
    public BlogResponseDto createBlog(BlogRequestDto requestDto, User user) {
        Blog blog = new Blog(requestDto, user);
        Blog target = blogRepository.save(blog);

        return new BlogResponseDto(target);
    }

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
    public OkMessage update(Long id,
                            BlogRequestDto requestDto,
                            User user
    ) throws IllegalAccessException {
        Blog blog = blogRepository.findById(id).orElseThrow();

        if (blog.getId().equals(user.getId()) || user.getRole().equals(UserRoleEnum.ADMIN)) {
            blog.update(requestDto);
            return new OkMessage(OK, "수정되었습니다.", new BlogResponseDto(blog));
        }
        throw new IllegalAccessException(ILLEGAL_ACCESS_MESSAGE);
    }

    @Transactional
    public OkMessage delete(Long id,
                            User user
    ) throws IllegalAccessException {
        Blog blog = blogRepository.findById(id).orElseThrow();

        if (blog.getId().equals(user.getId()) || user.getRole().equals(UserRoleEnum.ADMIN)) {
            blog.softDelete(true);
            return new OkMessage(OK, "삭제되었습니다.", new BlogResponseDto(blog));
        }
        throw new IllegalAccessException(ILLEGAL_ACCESS_MESSAGE);
    }
}