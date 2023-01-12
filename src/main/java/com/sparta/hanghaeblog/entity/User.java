package com.sparta.hanghaeblog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Validated
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private com.sparta.hanghaeblog.entity.UserRoleEnum role;

    @OneToMany
    List<Blog> blogs = new ArrayList<>();

    public User(String username, String password, com.sparta.hanghaeblog.entity.UserRoleEnum role){
        this.username = username;
        this.password = password;
        this.role = role;
    }
}
