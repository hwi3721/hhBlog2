package com.sparta.hanghaeblog.dto;

import com.sparta.hanghaeblog.entity.Blog;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
public class BlogResponseDto {
    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;
    private String title;
    private String contents;

    public BlogResponseDto(Blog target) {
        this.createdAt = target.getCreatedAt();
        this.modifiedAt = target.getModifiedAt();
        this.title = target.getTitle();
        this.contents = target.getContents();
    }
}