/*

 */

package com.rtarcisio.todo_back.controller;

import com.rtarcisio.todo_back.dtos.TodoDto;
import com.rtarcisio.todo_back.dtos.TodoUpdateDto;
import com.rtarcisio.todo_back.services.TodoService;
import com.rtarcisio.todo_back.services.exceptions.templ.StandardError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "CRUD REST APIs for Task Manager",
        description = "CRUD REST APIs in Task Manager to CREATE, UPDATE, FETCH AND DELETE ToDo details"
)
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


    @Operation(
            summary = "Create a Todo REST API",
            description = "REST API to create new Todo"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = TodoDto.class)
                    )
            )
    }
    )
    @PostMapping("/create")
    public ResponseEntity<TodoDto> createTodo(@Valid @RequestBody TodoDto dto) {

        TodoDto todo = todoService.createTodo(dto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId_todo())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @Operation(
            summary = "Edit ToDo REST API",
            description = "REST API to edit a ToDo"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "202",
                    description = "HTTP Status NO ACCEPTED"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "404 Not Found Error",
                    content = @Content(
                            schema = @Schema(implementation = StandardError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = StandardError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = StandardError.class)
                    )
            )
    }
    )
    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> editTodo(@RequestBody TodoUpdateDto objDto, @PathVariable Long id) {
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
