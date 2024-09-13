package com.instagram.mock.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserPostDto {
    private UserDto userDto;
    private PostDto postDto;
}
