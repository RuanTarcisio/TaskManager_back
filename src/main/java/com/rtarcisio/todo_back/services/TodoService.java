/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rtarcisio.todo_back.services;

import com.rtarcisio.todo_back.domains.Todo;
import com.rtarcisio.todo_back.dtos.TodoDto;
import com.rtarcisio.todo_back.dtos.TodoUpdateDto;
import com.rtarcisio.todo_back.resources.TodoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * @author ruantarcisio
 */

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public TodoDto createTodo(TodoDto dto) {

        Todo todo = toModel(dto);
        repository.save(todo);
        dto.setId_todo(todo.getId_todo());

        return dto;
    }

    public Todo findById(Long id) {
      return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Transactional
    public void deleteTodo(Long id) {

        var todo = findById(id);
        todo.cancel();
    }

    @Transactional
    public void editTodo(Long id, TodoUpdateDto dto){
        Todo todo = findById(id);
        todo.edit(dto);


    }

    private Todo toModel(TodoDto dto){
        Todo todo = new Todo();

        return todo.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .previsionToEnd(dto.getPrevisionToEnd())
                .started(LocalDateTime.now())
                .tags(dto.getTags().stream()
                        .map(tag -> Todo.TodoTagsEnum.valueOf(tag))
//                        .map(Todo.TodoTagsEnum::valueOf)
                        .collect(Collectors.toList()))
                .build();


    }

    private TodoDto toDto(Todo todo){
        TodoDto todoDto = new TodoDto();

        return todoDto.builder()
                .id_todo(todo.getId_todo())
                .title(todo.getTitle())
                .state(todo.getTodoState().name())
                .description(todo.getDescription())
                .previsionToEnd(todo.getPrevisionToEnd())
                .started(todo.getStarted())
                .finalized(todo.getFinalized())
                .tags(todo.getTags().stream()
                        .map(todoTagsEnum -> todoTagsEnum.name())
//                      .map(todoTagsEnum -> todoTagsEnum.name()) // Usa name() para obter a representação em String
                        .collect(Collectors.toList()))
                .build();
    }

}
