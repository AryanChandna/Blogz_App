package com.BlogApp.Blogz.services.impl;

import com.BlogApp.Blogz.entities.Comment;
import com.BlogApp.Blogz.entities.Post;
import com.BlogApp.Blogz.exceptions.ResourceNotFoundException;
import com.BlogApp.Blogz.payloads.CommentDto;
import com.BlogApp.Blogz.payloads.PostDto;
import com.BlogApp.Blogz.repositories.CommentRepo;
import com.BlogApp.Blogz.repositories.PostRepo;
import com.BlogApp.Blogz.services.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private CommentRepo commentRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CommentDto addComment(CommentDto commentDto, Integer postId) {
        Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));

        Comment comment = this.modelMapper.map(commentDto, Comment.class);

        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);

    }

    @Override
    public void deleteComment(Integer commentId) {
        Comment com = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","commentId", commentId));

        this.commentRepo.delete(com);

    }
}
