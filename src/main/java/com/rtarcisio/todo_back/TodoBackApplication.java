package com.rtarcisio.todo_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class TodoBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoBackApplication.class, args);
	}

}
