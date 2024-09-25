/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rtarcisio.todo_back.services;

import org.springframework.stereotype.Service;

import com.rtarcisio.todo_back.domains.Todo;
import com.rtarcisio.todo_back.dtos.TodoDto;
import com.rtarcisio.todo_back.resources.TodoRepository;

/**
 *
 * @author ruantarcisio
 */

 @Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }



    public Todo saveTodo(TodoDto dto) {
       
        
        return null;
    }

    public TodoDto findById(Long id) {
        var todo = repository.findById(id);
        return null;

    }

    

}
