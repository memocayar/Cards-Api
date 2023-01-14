package com.example.Cards.Api.controller;

import com.example.Cards.Api.dto.ListUserResponse;
import com.example.Cards.Api.dto.UserRequest;
import com.example.Cards.Api.dto.UserResponse;
import com.example.Cards.Api.service.UserServiceImp;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @PostMapping
    @Transactional
    public ResponseEntity<UserResponse> create(UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(userServiceImp.createUser(userRequest));
    }

    @GetMapping
    public ResponseEntity<ListUserResponse> getAll() {
        return ResponseEntity.ok().body(userServiceImp.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userServiceImp.getUserById(id));
    }
}
