package com.example.twitter.services;

import com.example.twitter.models.User;
import com.example.twitter.models.UserDTO;
import com.example.twitter.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<User> findAllUsers(){
        return this.userRepository.findAll();
    }

    public User addUser(UserDTO userDTO){
        String encryptPassword = passwordEncoder.encode(userDTO.getPassword());

        if(userRepository.findByEmail(userDTO.getEmail())!=null){
            return null;
        }
        User user = new User(userDTO.getName(),userDTO.getEmail(),encryptPassword);
        return this.userRepository.save(user);
    }

    public User checkCredentials(String email, String password){
        // find the user by email
        User user = userRepository.findByEmail(email);
        // Check password matches when encoded
        if (user != null && passwordEncoder.matches(password, user.getPassword())){
            return user;
        }
        // if no user matches then return null
        return null;
    }
}
