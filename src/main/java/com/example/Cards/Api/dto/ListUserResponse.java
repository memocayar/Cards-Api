package com.example.Cards.Api.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListUserResponse {

    List<UserResponse> users;
}
