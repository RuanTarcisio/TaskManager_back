/*

 */

package com.rtarcisio.todo_back.controller;

import com.rtarcisio.todo_back.dtos.TodoDto;
import com.rtarcisio.todo_back.dtos.TodoUpdateDto;
import com.rtarcisio.todo_back.services.TodoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


/**
 * @author ruantarcisio
 */
@RequestMapping("/todo")
@RestController
@Validated
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public String statusServer() {
        return "ok";
    }

    @PostMapping("/create")
    public ResponseEntity<TodoDto> createTodo(@Valid @RequestBody TodoDto dto) {

        TodoDto todo = todoService.createTodo(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId_todo())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editTodo(@RequestBody TodoUpdateDto objDto, @PathVariable Long id) {
        todoService.editTodo(id, objDto);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/close/{id}")
    public ResponseEntity<String> closeTodo(@PathVariable Long id) {
        
        todoService.closeTodo(id);
        return ResponseEntity.ok("Todo closed successfully.");
    }


    @PutMapping("/reopen/{id}")
    public ResponseEntity<String> reOpenTodo(@PathVariable Long id) {

        todoService.reOpenTodo(id);
        return ResponseEntity.ok("Todo re-opened successfully.");
    }

    @PutMapping("/cancel/{id}")
    public ResponseEntity<String> cancelTodo(@PathVariable Long id) {

        todoService.cancelTodo(id);
        return ResponseEntity.ok("Todo re-opened successfully.");
    }

//    @GetMapping("/{id}")
//    public String findById(@RequestParam Long id) {
//        TodoDto todo = todoService.findById(id);
//        return new String();
//    }


}
