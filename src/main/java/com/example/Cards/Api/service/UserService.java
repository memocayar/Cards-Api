package com.example.Cards.Api.service;

import com.example.Cards.Api.dto.ListUserResponse;
import com.example.Cards.Api.dto.UserRequest;
import com.example.Cards.Api.dto.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);

    UserResponse getUserById(Long id);

    ListUserResponse getAllUsers();

    UserResponse updateUser(UserRequest userRequest);

    void deleteUser(Long id);
}
