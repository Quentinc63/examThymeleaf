package com.humanbooster.exam.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.humanbooster.exam.model.Project;


@Service
public class ProjectService {

    private final List<Project> projects = new ArrayList<>(
        List.of(
            new Project(1L, "Project Alpha", null, new ArrayList<>()),
            new Project(2L, "Project Beta", null, new ArrayList<>()),
            new Project(3L, "Project Gamma", null, new ArrayList<>())
        )
    );

    public List<Project> getAllProjects() {
        return projects;
    }

    public void addProject(Project project) {
        project.setId((long) (projects.size() + 1));
        projects.add(project);
    }

    public Project getById(Long id) {
        return projects.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
}

