package com.humanbooster.exam.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.humanbooster.exam.model.Project;






// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// public class Project {
//     private Long id;
//     private String name;
//     private User creator;
//     private List<Task> tasks = new ArrayList<>();
// }
@Controller
public class ProjectController {

    private final List<Project> projects = new ArrayList<>(
        List.of(
            new Project(1L, "Project Alpha", null, new ArrayList<>()),
            new Project(2L, "Project Beta", null, new ArrayList<>()),
            new Project(3L, "Project Gamma", null, new ArrayList<>())
        )
    );

    @GetMapping("/projects/create")
    public String createProjectForm(Model model) {
        model.addAttribute("project", new Project());
        return "project-create";
    }

    @GetMapping("/projects")
    public String listProjects(Model model) {
        model.addAttribute("projectList", projects);
        return "project-list";

    }

    @GetMapping("/projects/{id}")
    public String viewProject(Model model, @PathVariable Long id) { // ← Ajoutez @PathVariable
        Project project = projects.stream()
            .filter(p -> p.getId().equals(id))
            .findFirst()
            .orElse(null);
    
        if (project != null) {
            model.addAttribute("project", project);
            return "project-detail"; // ← Changez le nom du template pour éviter confusion
        } else {
            return "redirect:/projects";
        }
    }

    

    
}
