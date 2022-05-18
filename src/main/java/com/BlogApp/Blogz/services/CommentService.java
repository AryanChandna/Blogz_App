package com.BlogApp.Blogz.services;

import com.BlogApp.Blogz.payloads.CommentDto;

public interface CommentService {

    CommentDto addComment(CommentDto commentDto, Integer postId);

    void deleteComment(Integer commentId);
}
