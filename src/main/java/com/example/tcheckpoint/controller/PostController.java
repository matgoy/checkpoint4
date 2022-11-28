package com.example.tcheckpoint.controller;

import com.example.tcheckpoint.entities.Post;
import com.example.tcheckpoint.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PostController {

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts")
    public String getPosts(Model out) {

        out.addAttribute("posts", postRepository.findAll());

        return "posts";
    }


    @GetMapping("/posts")
    public List<Post> getPosts(){
        return postRepository.findAll();
    }
}
