package com.humanbooster.exam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.humanbooster.exam.model.User;



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
    public String createUserForm() {
        return "user-create";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("userList", users);
        return "user"; 
    }
    
    
}
