package com.tintin.todo2.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tintin.todo2.pojo.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

    List<Task> findByUserId(Long userId);

    Task findByUserIdAndTaskId(Long userId, Long taskId);
}
