/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rtarcisio.todo_back.services;

import org.springframework.stereotype.Service;

import com.rtarcisio.todo_back.domains.Todo;
import com.rtarcisio.todo_back.dtos.TodoDto;

/**
 *
 * @author ruantarcisio
 */

 @Service
public class TodoService {

    public Todo saveTodo(TodoDto dto) {
       
        
        return null;
    }

    public TodoDto findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
