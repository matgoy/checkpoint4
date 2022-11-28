package com.example.tcheckpoint.controller;


import com.example.tcheckpoint.entities.User;
import com.example.tcheckpoint.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/users")
    public User postUser(@RequestBody User user){
        return userRepository.save(user);
    }


    @GetMapping("/users")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUsers(@PathVariable Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if ( optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/users/{id}")
    public User update(@PathVariable Integer id, @RequestBody User user) {
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/users/{id}")
    public void deletePost(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

}
