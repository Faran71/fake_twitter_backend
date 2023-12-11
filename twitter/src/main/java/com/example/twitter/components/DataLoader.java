package com.example.twitter.components;

import com.example.twitter.models.Comment;
import com.example.twitter.models.Tweet;
import com.example.twitter.models.User;
import com.example.twitter.repositories.CommentRepository;
import com.example.twitter.repositories.TweetRepository;
import com.example.twitter.repositories.UserRepository;
import com.example.twitter.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public void run(ApplicationArguments args) throws Exception {

//        List<User> users = Arrays.asList(
//                new User("Steve","@gmail","12345")
//        );
//        userRepository.saveAll(users);
        String encryptPassword = passwordEncoder.encode("12345");
        User user = new User("Steve","@gmail",encryptPassword);
        userRepository.save(user);

        List<Tweet> tweets = Arrays.asList(
                new Tweet(LocalDateTime.now(),"First Tweet",user),
                new Tweet(LocalDateTime.now(),"This is the first template for a twitter copy",user),
                new Tweet(LocalDateTime.now(),"If you want to be me then be me",user),
                new Tweet(LocalDateTime.now(),"Fourth Tweet",user)

        );

        tweetRepository.saveAll(tweets);

        Comment comment = new Comment("First Comment",user, tweets.get(0));

        commentRepository.save(comment);

    }
}
