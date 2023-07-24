package com.tintin.todo2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tintin.todo2.dao.TaskRepository;
import com.tintin.todo2.pojo.Task;

@RestController
@RequestMapping("/taskAPI")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("")
    String sayHi() {
        return "Hi, this is tasks api ";
    }

    @GetMapping("/{userId}")
    List<Task> allTasks(@PathVariable Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @GetMapping("/{userId}/{taskId}")
    Task getTaskById(@PathVariable Long userId, @PathVariable Long taskId) {
        return taskRepository.findByUserIdAndTaskId(userId, taskId);
    }
}
