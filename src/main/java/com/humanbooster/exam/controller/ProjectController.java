package com.humanbooster.exam.controller;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.humanbooster.exam.model.Project;
import com.humanbooster.exam.model.User;
import com.humanbooster.exam.service.ProjectService;
import com.humanbooster.exam.service.UserService;






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

    private final ProjectService projectService;
    private final UserService userService;

    public ProjectController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/projects")
    public String listProjects(Model model) {
        model.addAttribute("projectList", projectService.getAllProjects());
        return "project-list";
    }

    @GetMapping("/projects/create")
    public String createProjectForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("userList", userService.getAllUsers()); // pour le select
        return "project-create";
    }

    @PostMapping("/projects/create")
    public String createProject(@RequestParam String name, @RequestParam Long userId) {
        User creator = userService.getById(userId);
        if (creator != null) {
            Project project = new Project(null, name, creator, new ArrayList<>());
            projectService.addProject(project);
        }
        return "redirect:/projects";
    }

    @GetMapping("/projects/{id}")
    public String viewProject(@PathVariable Long id, Model model) {
        Project project = projectService.getById(id);
        if (project != null) {
            model.addAttribute("project", project);
            return "project-detail";
        } else {
            return "redirect:/projects";
        }
    }
}
