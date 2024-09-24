/*

 */

package com.rtarcisio.todo_back.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rtarcisio.todo_back.domains.Todo;
import com.rtarcisio.todo_back.dtos.TodoDto;
import com.rtarcisio.todo_back.services.TodoService;



/**
 *
 * @author ruantarcisio
 */
@RequestMapping("/todo")
@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping()
    public String statusServer(){
        return "ok";
    }

    @PostMapping("/create")
    public ResponseEntity<TodoDto> createTodo(@RequestBody TodoDto dto) {
        
        Todo todo = todoService.saveTodo(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId_todo())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public String findById(@RequestParam Long id) {
        TodoDto todo = todoService.findById(id);
        return new String();
    }
    

}
