package com.tintin.todo2.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tintin.todo2.pojo.Task;

@RepositoryRestResource(path = "tasksRepo", collectionResourceRel = "tasksRepo")
public interface TaskDataRestRepository extends PagingAndSortingRepository<Task,Long>{
    
}
