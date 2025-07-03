package com.humanbooster.exam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.humanbooster.exam.model.User;
import com.humanbooster.exam.service.UserService;

import jakarta.validation.Valid;



@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "user";
    }

    @GetMapping("/users/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User());
        return "user-create";
    }

    @PostMapping("/users/create")
    public String createUser(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-create";
        }

        userService.addUser(user);
        return "redirect:/users";
    }
}

