package com.tintin.todo2.init;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        List<Task> demoTasks = new ArrayList<>();
        demoTasks.add(new Task(0L,"test task","task to test",new Date(),new Date(),true));
        demoTasks.add(new Task(0L,"test task","task to test",new Date(),new Date(),true));
        return args -> {
            logger.info("Preloading " + taskRepository.saveAll(demoTasks));
        };
    }
}

