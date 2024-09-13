package com.instagram.mock.controller;

import com.instagram.mock.dto.UserDto;
import com.instagram.mock.dto.UserPostDto;
import com.instagram.mock.entity.Post;
import com.instagram.mock.entity.User;
import com.instagram.mock.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto save(@RequestBody User user){
        return userService.save(user);
    }

    @PostMapping("/addPost/{id}")
    public ResponseEntity<UserPostDto> savePost(@RequestBody Post post, @PathVariable Long id){
        return new ResponseEntity<>(userService.save(id,post), HttpStatus.CREATED );
    }
}
