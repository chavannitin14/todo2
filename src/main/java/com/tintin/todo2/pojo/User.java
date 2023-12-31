package com.tintin.todo2.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    @OneToMany(targetEntity = Task.class, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "userId")
    private List<Task> tasks;

    public User() {
    }

    public User(String name, List<Task> tasks) {
        this.name = name;
        this.tasks = tasks;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
