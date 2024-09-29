/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rtarcisio.todo_back.services;

import com.rtarcisio.todo_back.domains.Todo;
import com.rtarcisio.todo_back.dtos.TodoDto;
import com.rtarcisio.todo_back.dtos.TodoUpdateDto;
import com.rtarcisio.todo_back.enums.TodoTagsEnum;
import com.rtarcisio.todo_back.repositories.TodoRepository;
import com.rtarcisio.todo_back.services.exceptions.ObjetoNaoEncontradoException;
import com.rtarcisio.todo_back.state.TodoState;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
      return repository.findById(id).orElseThrow(() -> new ObjetoNaoEncontradoException("Not found ToDo"));
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

    public void closeTodo(Long id) {
        Todo todo = findById(id);
        todo.complete();
    }

    public void reOpenTodo(Long id) {
        Todo todo = findById(id);
        todo.reOpen();
    }

    public void cancelTodo(Long id) {
        Todo todo = findById(id);
        todo.cancel();
    }

    private Todo toModel(TodoDto dto){
        Todo todo = new Todo();

        return todo.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .previsionToEnd(dto.getPrevisionToEnd())
                .started(LocalDateTime.now())
                .todoState(TodoState.NEW)
                .tags(dto.getTags().stream()
                        .map(tag -> TodoTagsEnum.valueOf(tag.toUpperCase()))
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
                .modifiedAt(todo.getModifiedAt())
                .started(todo.getStarted())
                .finalized(todo.getFinalized())
                .tags(todo.getTags().stream()
                        .map(todoTagsEnum -> todoTagsEnum.name().toUpperCase())
//                      .map(todoTagsEnum -> todoTagsEnum.name()) // Usa name() para obter a representação em String
                        .collect(Collectors.toList()))
                .build();
    }

}
