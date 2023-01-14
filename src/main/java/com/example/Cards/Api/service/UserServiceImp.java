package com.example.Cards.Api.service;

import com.example.Cards.Api.dto.ListUserResponse;
import com.example.Cards.Api.dto.UserRequest;
import com.example.Cards.Api.dto.UserResponse;
import com.example.Cards.Api.entity.User;
import com.example.Cards.Api.mapper.UserMapper;
import com.example.Cards.Api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public UserResponse createUser(UserRequest userRequest){
        Optional<User> user = userMapper.map(userRequest);
        userRepository.save(user);

        return userMapper.map(user);
    }

    @Override
    public UserResponse getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return userMapper.map(user);
    }

    @Override
    public ListUserResponse getAllUsers() {
        List<User> users = userRepository.findAll();

        ListUserResponse usersResponse = new ListUserResponse();
        usersResponse.setUsers(userMapper.map(users));

        return usersResponse;
    }

    @Override
    public UserResponse updateUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
