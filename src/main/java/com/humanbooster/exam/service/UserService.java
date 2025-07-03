package com.humanbooster.exam.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.humanbooster.exam.model.User;



@Service
public class UserService {
    
    private static final List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        user.setId((long) (users.size() + 1));
        users.add(user);
    }

    public User getById(Long id) {
        return users.stream()
            .filter(u -> u.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
}
