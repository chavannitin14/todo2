package com.tintin.todo2;

import org.apache.tomcat.jni.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.tintin.todo2.pojo.Task;

@SpringBootApplication
public class Todo2Application {

	public static void main(String[] args) {
		SpringApplication.run(Todo2Application.class, args);
	}

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer() {
		return RepositoryRestConfigurer.withConfig(config -> {
			config.exposeIdsFor(Task.class);
			config.exposeIdsFor(User.class);
		});
	}
}
