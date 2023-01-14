package com.example.Cards.Api.mapper;

import com.example.Cards.Api.dto.UserRequest;
import com.example.Cards.Api.dto.UserResponse;
import com.example.Cards.Api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserMapper {
    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public User map(UserRequest userRequest){
        User user = new User();

        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        return user;
    }

    public UserResponse map(User user){
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());

        return response;
    }

    public List<UserResponse> map(List<User> users){
        List<UserResponse> listResponse = new ArrayList<>();

        for(User user : users){
            listResponse.add(map(user));
        }

        return listResponse;
    }
}
