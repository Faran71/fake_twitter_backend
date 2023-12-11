package com.example.twitter.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"comments","tweets"})
    private User user;

    @ManyToOne
    @JoinColumn(name = "tweet_id")
    @JsonIgnoreProperties({"comments","user"})
    private Tweet tweet;

    public Comment() {
    }

    public Comment(String comment, User user, Tweet tweet) {
        this.comment = comment;
        this.user = user;
        this.tweet = tweet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tweet getTweet() {
        return tweet;
    }

    public void setTweet(Tweet tweet) {
        this.tweet = tweet;
    }
}
