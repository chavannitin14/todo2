package com.tintin.todo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tintin.todo2.pojo.User;

public interface UserRepository extends JpaRepository<User,Long>{
}
