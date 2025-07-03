package com.humanbooster.exam.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.humanbooster.exam.model.Task;


@Service
public class TaskService {

    private static final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }
    public void addTask(Task task) {
        task.setId((long) (tasks.size() + 1));
        tasks.add(task);
    }
    public Task getById(Long id) {
        return tasks.stream()
            .filter(t -> t.getId().equals(id))
            .findFirst()
            .orElse(null);
    }
    
}
