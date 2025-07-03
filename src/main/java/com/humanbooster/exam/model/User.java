package com.humanbooster.exam.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    @NotEmpty(message = "Username doit pas être vide")
    private String username;
}