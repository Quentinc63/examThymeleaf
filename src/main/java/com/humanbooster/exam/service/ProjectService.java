package com.humanbooster.exam.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.humanbooster.exam.model.Project;


@Service
public class ProjectService {

    private static final List<Project> projects = new ArrayList<>();

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

