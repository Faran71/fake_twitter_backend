package com.example.twitter.controllers;

import com.example.twitter.models.Tweet;
import com.example.twitter.repositories.TweetRepository;
import com.example.twitter.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/tweets"})
public class TweetController {

    @Autowired
    TweetService tweetService;

    @Autowired
    TweetRepository tweetRepository;

    @GetMapping
    public ResponseEntity<List<Tweet>> getAllTweets(){
        return new ResponseEntity(tweetService.findAllTweets(), HttpStatus.FOUND);
    }

    @PostMapping(value = "postTweet/{userId}")
    public ResponseEntity<List<Tweet>> postTweet(@PathVariable Long userId, @RequestBody String Content){
        Tweet createTweet = tweetService.createTweet(userId, Content);
        return new ResponseEntity(tweetRepository.findAll() ,HttpStatus.CREATED);
    }

    @PostMapping(value = "likeTweet/{tweetId}/{userId}")
    public ResponseEntity<Tweet> likeTweet(@PathVariable Long tweetId, @PathVariable Long userId){
        Tweet updatedTweet = tweetService.likeTweet(tweetId,userId);
        return new ResponseEntity<>(updatedTweet,HttpStatus.ACCEPTED);
    }
}
