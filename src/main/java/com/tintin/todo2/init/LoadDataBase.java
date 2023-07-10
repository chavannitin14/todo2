package com.tintin.todo2.init;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tintin.todo2.dao.TaskRepository;
import com.tintin.todo2.pojo.Task;

@Configurable
@Configuration
public class LoadDataBase {
    private static final Logger logger = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(TaskRepository taskRepository){
        return args -> {
            logger.info("Preloading" + taskRepository.save(new Task(0L,"test task","task to test",new Date(),new Date(),true)));
            logger.info("Preloading" + taskRepository.save(new Task(0L,"test task","task to test",new Date(),new Date(),true)));
        };
    }
}

