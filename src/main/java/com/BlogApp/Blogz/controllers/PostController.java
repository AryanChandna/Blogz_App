package com.BlogApp.Blogz.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.BlogApp.Blogz.payloads.ApiResponse;
import com.BlogApp.Blogz.payloads.PostDto;
import com.BlogApp.Blogz.services.PostService;
import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;


//	create

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer userId,
                                              @PathVariable Integer categoryId) {
        PostDto createPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<PostDto>(createPost, HttpStatus.CREATED);
    }

    //get posts by user
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable Integer userId) {

        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

    }

    // get by category

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable Integer categoryId) {

        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

    }
    //get all posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> getAllPosts(@RequestParam(value = "pageNumber", defaultValue ="1",required = false)Integer pageNumber, @RequestParam(value="pageSize",defaultValue ="5",required = false) Integer pageSize) {

        List<PostDto> posts = this.postService.getAllPosts(pageNumber, pageSize);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

    }
    //get post by id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getSinglePostbyId(@PathVariable Integer postId){

        PostDto getSingle = this.postService.getPostById(postId);
        return new ResponseEntity<PostDto>(getSingle, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer postId){

        PostDto updatedPost = this.postService.updatePost(postDto, postId);
        return new ResponseEntity<PostDto>(updatedPost, HttpStatus.OK);
    }
    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePostbyId(@PathVariable Integer postId){

        this.postService.deletePost(postId);
        return new ApiResponse("Post is successfully deleted", true);
    }


}
