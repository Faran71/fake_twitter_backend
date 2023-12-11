package com.example.twitter.services;

import com.example.twitter.models.Tweet;
import com.example.twitter.models.User;
import com.example.twitter.repositories.TweetRepository;
import com.example.twitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TweetService {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    UserRepository userRepository;

    public List<Tweet> findAllTweets(){
        return tweetRepository.findAll();
    }

    public Tweet createTweet(Long userId, String Content){
        Tweet newTweet = new Tweet();
        User user = userRepository.findById(userId).get();
        newTweet.setUser(user);
        newTweet.setTweetDateTime(LocalDateTime.now());
        newTweet.setContent(Content);
        newTweet.setUsersLikedTweet(new ArrayList<>());
        tweetRepository.save(newTweet);
        return newTweet;
    }

    public Tweet likeTweet(Long tweetId, Long userId){
        Tweet changeTweet = tweetRepository.findById(tweetId).get();
        User userThatLiked = userRepository.findById(userId).get();
        List<String> usersThatLikedTweet = changeTweet.getUsersLikedTweet();
        if (!usersThatLikedTweet.contains(userThatLiked.getEmail())) {
            usersThatLikedTweet.add(userThatLiked.getEmail());
            changeTweet.setUsersLikedTweet(usersThatLikedTweet);
            tweetRepository.save(changeTweet);
        } else {
            usersThatLikedTweet.remove(userThatLiked.getEmail());
            changeTweet.setUsersLikedTweet(usersThatLikedTweet);
            tweetRepository.save(changeTweet);
        }
        return changeTweet;
    }


}
