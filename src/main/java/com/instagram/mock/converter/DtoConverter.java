package com.instagram.mock.converter;

import com.instagram.mock.dto.PostDto;
import com.instagram.mock.dto.UserDto;
import com.instagram.mock.dto.UserPostDto;
import com.instagram.mock.entity.Post;
import com.instagram.mock.entity.User;

public class DtoConverter {
    public static UserPostDto convertUserPostDto(User user, Post post){
        UserDto userDto = new UserDto(user.getId(), user.getUsername(), user.getEmail(), user.getPhone(), user.getCreatedAt());
        PostDto postDto = new PostDto(post.getId() , post.getImgPath(), post.getDescription());
        UserPostDto userPostDto = new UserPostDto(userDto, postDto);
        return userPostDto;
    }
}
