package com.instagram.mock.service;

import com.instagram.mock.dto.UserDto;
import com.instagram.mock.dto.UserPostDto;
import com.instagram.mock.entity.Post;
import com.instagram.mock.entity.User;

public interface UserService {
    UserDto save(User user);
    UserPostDto save(Long id,Post post);
}
