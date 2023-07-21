package com.tintin.todo2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.tintin.todo2.pojo.Task;

@RepositoryRestResource(path = "task", collectionResourceRel = "tasks")
public interface TaskDataRestRepository extends CrudRepository<Task, Long> {
}
