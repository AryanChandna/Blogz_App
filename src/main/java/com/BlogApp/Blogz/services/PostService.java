package com.BlogApp.Blogz.services;

import com.BlogApp.Blogz.entities.Post;
import com.BlogApp.Blogz.payloads.PostDto;
import com.BlogApp.Blogz.payloads.PostResponse;

import java.util.List;

public interface PostService {

    //create

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    //update

    PostDto updatePost(PostDto postDto, Integer postId);

    // delete

    void deletePost(Integer postId);

    //get single post

    PostDto getPostById(Integer postId);

    // get all posts

    PostResponse getAllPosts(Integer pageNumber, Integer pageSize);

    //get all posts by category

    List<PostDto> getPostsByCategory(Integer categoryId);

    //get all posts by user
    List<PostDto> getPostsByUser(Integer userId);

    //search posts
    List<PostDto> searchPosts(String keyword);

}