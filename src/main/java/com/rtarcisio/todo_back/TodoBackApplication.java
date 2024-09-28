package com.rtarcisio.todo_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableJpaAuditing
public class TodoBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoBackApplication.class, args);
	}

}
