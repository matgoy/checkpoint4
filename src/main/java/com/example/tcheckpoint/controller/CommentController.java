package com.example.tcheckpoint.controller;


import com.example.tcheckpoint.entities.Comment;
import com.example.tcheckpoint.entities.Post;
import com.example.tcheckpoint.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PostMapping("/comments")
    public Comment postComments(@RequestBody Comment comment){
        return commentRepository.save(comment);
    }


    @GetMapping("/comments")
    public List<Comment> getComments(){
        return commentRepository.findAll();
    }
}
