package com.humanbooster.exam.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.humanbooster.exam.model.Project;
import com.humanbooster.exam.model.Task;
import com.humanbooster.exam.model.TaskStatus;
import com.humanbooster.exam.model.User;
import com.humanbooster.exam.service.ProjectService;
import com.humanbooster.exam.service.TaskService;
import com.humanbooster.exam.service.UserService;

import jakarta.validation.Valid;
    

@Controller
public class TaskController {

    private final ProjectService projectService;
    private final UserService userService;
    private final TaskService taskService;

    public TaskController(ProjectService projectService, UserService userService) {
        this.projectService = projectService;
        this.userService = userService;
        this.taskService = new TaskService(); 
    }

    @GetMapping("/tasks/create")
    public String createTask(Model model) {
        Task task = new Task();
        task.setAssignee(new User());
        model.addAttribute("task", new Task());
        model.addAttribute("userList", userService.getAllUsers()); 
        model.addAttribute("projectList", projectService.getAllProjects());
        model.addAttribute("taskStatuses", TaskStatus.values()); 
        return "task-create"; 
    }

    @PostMapping("/tasks/create")
    public String saveTask(@Valid @ModelAttribute Task task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userList", userService.getAllUsers());
            model.addAttribute("projectList", projectService.getAllProjects());
            model.addAttribute("taskStatuses", TaskStatus.values());
            return "task-create";
        }

        if (task.getProject() != null && task.getProject().getId() != null) {
            Project project = projectService.findById(task.getProject().getId());
            task.setProject(project);
            project.getTasks().add(task); 
        }

        if (task.getAssignee() != null && task.getAssignee().getId() != null) {
            User user = userService.getById(task.getAssignee().getId());
            task.setAssignee(user);
        }

        taskService.addTask(task);

        return "redirect:/projects";
    }

    
    
}
