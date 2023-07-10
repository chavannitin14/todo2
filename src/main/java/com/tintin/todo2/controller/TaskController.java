package com.tintin.todo2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tintin.todo2.dao.TaskRepository;
import com.tintin.todo2.pojo.Task;

@RestController
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/Hi")
    String sayHi() {
        return "Hi";
    }

    @GetMapping("/tasks")
    List<Task> allTask() {
        return taskRepository.findAll();
    }

    @GetMapping("/tasks/{userId}")
    List<Task> allUserTask(@PathVariable Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @GetMapping("/task/{userId}/{taskId}")
    Task getTaskById(@PathVariable Long userId, @PathVariable Long taskId) {
        return taskRepository.findByUserIdAndTaskId(userId, taskId);
    }
}
