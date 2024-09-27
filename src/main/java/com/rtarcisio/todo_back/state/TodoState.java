/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.rtarcisio.todo_back.state;

import com.rtarcisio.todo_back.domains.Todo;
import com.rtarcisio.todo_back.dtos.TodoUpdateDto;

import java.time.LocalDateTime;

/**
 *
 * @author ruantarcisio
 */
public enum TodoState implements StateInterface {

    CLOSED {
        @Override
        public void reOpen(Todo todo) {
            throw new UnsupportedOperationException("Cannot start a canceled todo.");
        }

        @Override
        public void complete(Todo todo) {
            throw new UnsupportedOperationException("Cannot complete a canceled todo.");
        }

        @Override
        public void close(Todo todo) {
            throw new UnsupportedOperationException("Todo is already canceled.");
        }

        @Override
        public void edit(Todo todo, TodoUpdateDto dto) {
            throw new UnsupportedOperationException("Todo is already canceled.");
        }
    },
    COMPLETED {
        @Override
        public void reOpen(Todo todo) {
            throw new UnsupportedOperationException("Cannot start a completed todo.");
        }

        @Override
        public void complete(Todo todo) {
            throw new UnsupportedOperationException("Todo is already completed.");
        }

        @Override
        public void close(Todo todo) {
            throw new UnsupportedOperationException("Cannot cancel a completed todo.");
        }

        @Override
        public void edit(Todo todo, TodoUpdateDto dto) {

        }
    },
    IN_PROGRESS {
        @Override
        public void reOpen(Todo todo) {
            throw new UnsupportedOperationException("Todo is already in progress.");
        }

        @Override
        public void complete(Todo todo) {
            todo.setTodoState(COMPLETED);
            todo.setFinalized(LocalDateTime.now());
        }

        @Override
        public void close(Todo todo) {
            todo.setTodoState(CLOSED);
        }

        @Override
        public void edit(Todo todo, TodoUpdateDto dto) {

        }
    },
    NEW {
        @Override
        public void reOpen(Todo todo) {
            todo.setTodoState(IN_PROGRESS);
            todo.setStarted(LocalDateTime.now());
        }

        @Override
        public void complete(Todo todo) {
            throw new UnsupportedOperationException("Cannot complete a new todo.");
        }

        @Override
        public void close(Todo todo) {
            todo.setTodoState(CLOSED);
        }

        @Override
        public void edit(Todo todo, TodoUpdateDto dto) {

        }
    };
//
//    // Métodos abstratos para cada operação
//    public abstract void start(Todo todo);
//
//    public abstract void complete(Todo todo);
//
//    public abstract void cancel(Todo todo);
}