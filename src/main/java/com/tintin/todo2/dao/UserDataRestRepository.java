package com.tintin.todo2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tintin.todo2.pojo.User;
@RepositoryRestResource(path = "user")
public interface UserDataRestRepository extends CrudRepository<User,Long>{    
}
