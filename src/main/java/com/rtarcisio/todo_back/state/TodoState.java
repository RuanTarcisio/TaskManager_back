/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.rtarcisio.todo_back.state;

import com.rtarcisio.todo_back.domains.Todo;

import java.time.LocalDateTime;

/**
 *
 * @author ruantarcisio
 */
public enum TodoState{

    NEW {
        @Override
        public void start(Todo todo) {
            todo.setTodoState(IN_PROGRESS);
            todo.setStarted(LocalDateTime.now());
        }

        @Override
        public void complete(Todo todo) {
            throw new UnsupportedOperationException("Cannot complete a new todo.");
        }

        @Override
        public void cancel(Todo todo) {
            todo.setTodoState(CANCELED);
        }
    },
    IN_PROGRESS {
        @Override
        public void start(Todo todo) {
            throw new UnsupportedOperationException("Todo is already in progress.");
        }

        @Override
        public void complete(Todo todo) {
            todo.setTodoState(COMPLETED);
            todo.setFinalized(LocalDateTime.now());
        }

        @Override
        public void cancel(Todo todo) {
            todo.setTodoState(CANCELED);
        }
    },
    COMPLETED {
        @Override
        public void start(Todo todo) {
            throw new UnsupportedOperationException("Cannot start a completed todo.");
        }

        @Override
        public void complete(Todo todo) {
            throw new UnsupportedOperationException("Todo is already completed.");
        }

        @Override
        public void cancel(Todo todo) {
            throw new UnsupportedOperationException("Cannot cancel a completed todo.");
        }
    },
    CANCELED {
        @Override
        public void start(Todo todo) {
            throw new UnsupportedOperationException("Cannot start a canceled todo.");
        }

        @Override
        public void complete(Todo todo) {
            throw new UnsupportedOperationException("Cannot complete a canceled todo.");
        }

        @Override
        public void cancel(Todo todo) {
            throw new UnsupportedOperationException("Todo is already canceled.");
        }
    };

    // Métodos abstratos para cada operação
    public abstract void start(Todo todo);
    public abstract void complete(Todo todo);
    public abstract void cancel(Todo todo);
}