package com.BlogApp.Blogz.controllers;

import com.BlogApp.Blogz.entities.Comment;
import com.BlogApp.Blogz.payloads.ApiResponse;
import com.BlogApp.Blogz.payloads.CommentDto;
import com.BlogApp.Blogz.services.CommentService;
import com.BlogApp.Blogz.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private PostService postService;

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto, @PathVariable Integer postId){


       CommentDto createComment = this.commentService.addComment(commentDto, postId);
        return new ResponseEntity<CommentDto>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ApiResponse deleteComment(@PathVariable Integer commentId){

        this.commentService.deleteComment(commentId);
        return new ApiResponse("Comment deleted successfully", true);
    }



}
