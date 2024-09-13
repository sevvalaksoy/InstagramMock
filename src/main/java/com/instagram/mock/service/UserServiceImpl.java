package com.instagram.mock.service;

import com.instagram.mock.converter.DtoConverter;
import com.instagram.mock.dto.UserDto;
import com.instagram.mock.dto.UserPostDto;
import com.instagram.mock.entity.Post;
import com.instagram.mock.entity.User;
import com.instagram.mock.exceptions.EmailPhoneExistException;
import com.instagram.mock.exceptions.UserDoesNotExistsException;
import com.instagram.mock.repository.PostRepository;
import com.instagram.mock.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private PostService postService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PostService postService){
        this.userRepository = userRepository;
        this.postService = postService;
    }

    @Override
    public UserDto save(User user) {
        user.setCreatedAt(LocalDateTime.now());
        if((user.getEmail() == null || user.getEmail().isEmpty()) && (user.getPhone() == null || user.getPhone().isEmpty())){
            throw new EmailPhoneExistException("User should have at least an email or phone number", HttpStatus.BAD_REQUEST);
        }
        User savedUser = userRepository.save(user);
        return new UserDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(),
                savedUser.getPhone(), savedUser.getCreatedAt());
    }

    @Override
    public UserPostDto save(Long id, Post post) {
        post.setCreatedAt(LocalDateTime.now());
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User foundUser = optionalUser.get();
            post.setUser(foundUser);
            foundUser.addPost(post);
            //User savedUser = userRepository.save(foundUser);
            postService.save(post);
            return DtoConverter.convertUserPostDto(foundUser, post);
        } else {
            throw new UserDoesNotExistsException("There is no user with the given id: "+ id);
        }
    }
}
