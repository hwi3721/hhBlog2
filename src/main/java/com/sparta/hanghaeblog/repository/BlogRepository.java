package com.sparta.hanghaeblog.repository;


import com.sparta.hanghaeblog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
    List<Blog> findAllByOrderByCreatedAtDesc();

    Blog findByTitle(String title);

}