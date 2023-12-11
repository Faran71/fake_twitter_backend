package com.example.twitter.controllers;

import com.example.twitter.models.Comment;
import com.example.twitter.models.Tweet;
import com.example.twitter.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/comments"})
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping
    public ResponseEntity<List<Comment>> getAllComments(){
        return new ResponseEntity(commentService.findAllComments(), HttpStatus.FOUND);
    }

    @GetMapping(value = "/tweet/{tweetId}")
    public ResponseEntity<List<Comment>> getCommentsForTweet(@PathVariable Long tweetId){
        return new ResponseEntity<>(commentService.findCommentsWithTweet(tweetId),HttpStatus.FOUND);
    }

    @PostMapping(value = "/writeComment/{userId}/{tweetId}")
    public ResponseEntity<List<Comment>> writeComment(@PathVariable Long userId, @PathVariable Long tweetId, @RequestBody String comment){
        Comment newComment = commentService.addComment(comment,userId,tweetId);
        return new ResponseEntity<>(commentService.findCommentsWithTweet(tweetId),HttpStatus.OK);
    }
}
