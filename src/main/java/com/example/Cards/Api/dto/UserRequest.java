package com.example.Cards.Api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

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
