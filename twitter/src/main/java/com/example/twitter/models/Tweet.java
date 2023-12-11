package com.example.twitter.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tweets")
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name="tweet_date_time")
    private LocalDateTime tweetDateTime;

    @Column
    private String content;

    @Column
    private List<String> usersLikedTweet;

//    @ManyToMany(mappedBy = "tweets")
//    private List<User> userLikedTweet;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"tweets"})
    private User user;

    @OneToMany(mappedBy = "tweet")
    @JsonIgnoreProperties({"tweet","user"})
    private List<Comment> comments;


    public Tweet() {
    }

    public Tweet(LocalDateTime tweetDateTime, String content, User user) {
        this.tweetDateTime = tweetDateTime;
        this.content = content;
        this.user = user;
        this.usersLikedTweet = new ArrayList<>();
        this.comments = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTweetDateTime() {
        return tweetDateTime;
    }

    public void setTweetDateTime(LocalDateTime tweetDateTime) {
        this.tweetDateTime = tweetDateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public int getLikes() {
//        return likes;
//    }
//
//    public void setLikes(int likes) {
//        this.likes = likes;
//    }


    public List<String> getUsersLikedTweet() {
        return usersLikedTweet;
    }

    public void setUsersLikedTweet(List<String> usersLikedTweet) {
        this.usersLikedTweet = usersLikedTweet;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
