package com.example.tcheckpoint.entities;

import jakarta.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String message;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, optional = true)
    @JoinColumn(name = "Post_id", nullable = true)
    private Post post;

    public Comment(){
        this.post = getPost();
    }

    private Post getPost() {
        return post;
    }
    public void setPost(Post post) {

        this.post = post;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
