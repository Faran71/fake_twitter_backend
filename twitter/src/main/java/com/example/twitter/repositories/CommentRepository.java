package com.example.twitter.repositories;

import com.example.twitter.models.Comment;
import com.example.twitter.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByTweet(Tweet tweet);
}
