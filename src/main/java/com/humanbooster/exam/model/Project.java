package com.humanbooster.exam.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long id;

    @NotEmpty(message = "Le nom du projet ne doit pas être vide")
    private String name;

    @NotEmpty(message = "Le créateur du projet ne doit pas être vide")
    private User creator;

    
    private List<Task> tasks = new ArrayList<>();
}