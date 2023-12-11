package com.example.twitter.services;

import com.example.twitter.models.Comment;
import com.example.twitter.models.Tweet;
import com.example.twitter.models.User;
import com.example.twitter.repositories.CommentRepository;
import com.example.twitter.repositories.TweetRepository;
import com.example.twitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    UserRepository userRepository;

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public List<Comment> findCommentsWithTweet(Long tweetID){
        Tweet tweet = tweetRepository.findById(tweetID).get();
        return commentRepository.findByTweet(tweet);
    }

    public Comment addComment(String comment, Long userId, Long tweetId) {
        Comment newComment = new Comment();
        User user = userRepository.findById(userId).get();
        Tweet tweet = tweetRepository.findById(tweetId).get();
        newComment.setComment(comment);
        newComment.setTweet(tweet);
        newComment.setUser(user);
        commentRepository.save(newComment);
        return newComment;
    }
}
