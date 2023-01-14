package com.example.Cards.Api.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class UserRequest {
    @NotEmpty(message = "Name cannot be empty.")
    private String name;

    @NotEmpty(message = "Email cannot be empty.")
    @Email(message = "Please enter a valid email.")
    private String email;

    @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters.")
    private String password;
}
