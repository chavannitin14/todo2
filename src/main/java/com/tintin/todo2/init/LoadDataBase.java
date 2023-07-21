package com.tintin.todo2.init;

import java.util.ArrayList;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tintin.todo2.dao.UserRepository;
import com.tintin.todo2.pojo.Task;
import com.tintin.todo2.pojo.User;

@Configurable
@Configuration
public class LoadDataBase {
    private static final Logger logger = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository){
        
        User testUser = new User("Test User", new ArrayList<>());
        testUser.getTasks().add(new Task("test task 1","task to test 1 desc",new Date(),new Date(),true));
        testUser.getTasks().add(new Task("test task 2","task to test 2 desc",new Date(),new Date(),true));
        return args -> {
            logger.info("Preloading " + userRepository.save(testUser));
        };
    }
}

