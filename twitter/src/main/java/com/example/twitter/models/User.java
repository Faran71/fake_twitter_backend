package com.example.twitter.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

//    @ManyToMany
//    @JoinTable(name = "user_likedTweet",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "tweet_id"))
//    private List<Tweet> likedTweets;


    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user"})
    private List<Tweet> tweets;

    @OneToMany(mappedBy = "user")
    @JsonIgnoreProperties({"user","tweets"})
    private List<Comment> comments;

    public User() {
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.tweets = new ArrayList<>();
        this.comments = new ArrayList<>();
//        this.likedTweets = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

//    public List<Tweet> getLikedTweets() {
//        return likedTweets;
//    }
//
//    public void setLikedTweets(List<Tweet> likedTweets) {
//        this.likedTweets = likedTweets;
//    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
