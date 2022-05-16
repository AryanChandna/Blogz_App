package com.BlogApp.Blogz.repositories;

import java.util.List;

import com.BlogApp.Blogz.entities.Category;
import com.BlogApp.Blogz.entities.Post;
import com.BlogApp.Blogz.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
    }