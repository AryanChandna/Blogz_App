package com.BlogApp.Blogz.repositories;

import com.BlogApp.Blogz.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
