package com.humanbooster.exam.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Long id;

    @NotBlank(message = "Le titre est obligatoire")
    private String title;

    @NotNull(message = "Le statut est obligatoire")
    private TaskStatus status;

    @NotNull(message = "L'assigné est obligatoire")
    private User assignee;

    @NotNull(message = "Le projet est obligatoire")
    private Project project;
}
