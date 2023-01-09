package com.sparta.hanghaeblog.entity;

import com.sparta.hanghaeblog.dto.BlogRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity(name = "BlogId")
@NoArgsConstructor
public class Blog extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String contents;

    private Boolean isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="users")
    private User user;


    public Blog(BlogRequestDto blogrequestDto) {
        this.contents = blogrequestDto.getContents();
        this.title = blogrequestDto.getTitle();
    }

    public Blog(BlogRequestDto blogRequestDto, User user){
        this.title = blogRequestDto.getTitle();
        this.contents = blogRequestDto.getContents();;
        this.user = user;
        this.isDeleted = null;
    }

    public void update(BlogRequestDto blogRequestDto) {
        this.contents = blogRequestDto.getContents();
        this.title = blogRequestDto.getTitle();
    }

    public String getUsername() {
        return this.user.getUsername();
    }
    public void softDelete(Boolean b){
        this.isDeleted = b;
    }


}