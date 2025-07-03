package com.humanbooster.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.humanbooster.exam.model.User;

import jakarta.validation.Valid;



@Controller

public class UserController {

    private final List<User> users = new ArrayList<>(
        List.of(
            new User(1L, "john_doe"),
            new User(2L, "jane_doe"),
            new User(3L, "alice_smith")
        )
    );

    @GetMapping("/users/create")
    public String createUserForm(Model model) {
        model.addAttribute("user", new User()); // ← Vous créez l'objet ici
        return "user-create";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("userList", users);
        return "user"; 
    }

    @PostMapping("/users/create")
    public String createUser(@Valid @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "user-create"; 
        }
        
        user.setId((long) (users.size() + 1));
        users.add(user);
        return "redirect:/users"; 
    }
    
    
}
