package com.instagram.mock.dto;

import java.time.LocalDateTime;

public record UserDto(Long id, String username, String email, String phone, LocalDateTime createdAt) {
}
