package com.humanbooster.exam.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Long id;
    private String name;
    private User creator;
    private List<Task> tasks = new ArrayList<>();
}