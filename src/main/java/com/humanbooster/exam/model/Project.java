package com.humanbooster.exam.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long id;

     @NotBlank(message = "Le nom est obligatoire")
    private String name;

    @NotNull(message = "Le créateur est obligatoire")
    private User creator;


    private List<Task> tasks = new ArrayList<>();
}