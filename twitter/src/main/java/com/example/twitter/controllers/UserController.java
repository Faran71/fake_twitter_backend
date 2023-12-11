package com.example.twitter.controllers;

import com.example.twitter.authentication.LogInForm;
import com.example.twitter.models.User;
import com.example.twitter.models.UserDTO;
import com.example.twitter.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/users"})
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @PostMapping
    public ResponseEntity<User> postUser(@RequestBody UserDTO userDTO){
        User addUser = userService.addUser(userDTO);
//        return new ResponseEntity<>(addUser,HttpStatus.CREATED);
        return addUser != null ? new ResponseEntity<>(addUser,HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticateUser(@RequestBody LogInForm logInForm){
        User checkUser = userService.checkCredentials(logInForm.getEmail(), logInForm.getPassword());
        return checkUser != null ? new ResponseEntity<>(checkUser,HttpStatus.ACCEPTED) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
//        return new ResponseEntity<>(checkUser, HttpStatus.OK);
    }
}
