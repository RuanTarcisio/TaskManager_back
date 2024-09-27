/*

 */

package com.rtarcisio.todo_back.controller;

import java.net.URI;

import com.rtarcisio.todo_back.dtos.TodoUpdateDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
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
@Validated
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
    public ResponseEntity<TodoDto> createTodo(@Valid @RequestBody TodoDto dto) {
        
        TodoDto todo = todoService.createTodo(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId_todo())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> editTodo(@RequestBody TodoUpdateDto objDto, @PathVariable Long id){
        todoService.editTodo(id, objDto);
        return ResponseEntity.accepted().build();
    }


//    @GetMapping("/{id}")
//    public String findById(@RequestParam Long id) {
//        TodoDto todo = todoService.findById(id);
//        return new String();
//    }
    

}
