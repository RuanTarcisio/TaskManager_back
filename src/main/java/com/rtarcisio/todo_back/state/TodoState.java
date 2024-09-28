/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.rtarcisio.todo_back.state;

import com.rtarcisio.todo_back.domains.Todo;
import com.rtarcisio.todo_back.dtos.TodoUpdateDto;
import com.rtarcisio.todo_back.enums.TodoTagsEnum;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 *PENDING, IN_PROGRESS, COMPLETED
 * @author ruantarcisio
 */
public enum TodoState implements StateInterface {

    NEW {
        @Override
        public void reOpen(Todo todo) {
            throw new UnsupportedOperationException("Todo is already opened.");
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

        @Override
        public void edit(Todo todo, TodoUpdateDto dto) {
            TodoState.modifyDto(todo, dto);
            todo.setTodoState(IN_PROGRESS);
        }
    },IN_PROGRESS {
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
        public void cancel(Todo todo) {
            todo.setTodoState(COMPLETED);
        }

        @Override
        public void edit(Todo todo, TodoUpdateDto dto) {
            TodoState.modifyDto(todo, dto);
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
        public void cancel(Todo todo) {
            throw new UnsupportedOperationException("Cannot cancel a completed todo.");
        }

        @Override
        public void edit(Todo todo, TodoUpdateDto dto) {
            throw new UnsupportedOperationException("Cannot edit a completed todo.");
        }
    },
    CANCELED {
        @Override
        public void reOpen(Todo todo) {
            todo.setTodoState(REOPENED);
        }

        @Override
        public void complete(Todo todo) {
            throw new UnsupportedOperationException("Cannot cancel a canceled todo.");
        }

        @Override
        public void cancel(Todo todo) {
            throw new UnsupportedOperationException("Todo is already canceled.");

            //throw new UnsupportedOperationException("Cannot cancel a completed todo.");
        }

        @Override
        public void edit(Todo todo, TodoUpdateDto dto) {
            throw new UnsupportedOperationException("Cannot edit a completed todo.");
        }
    },
    REOPENED {
        @Override
        public void reOpen(Todo todo) {
            throw new UnsupportedOperationException("Todo is already reopened.");
        }

        @Override
        public void complete(Todo todo) {
            todo.setTodoState(COMPLETED);
        }

        @Override
        public void cancel(Todo todo) {
            todo.setTodoState(CANCELED);
        }

        @Override
        public void edit(Todo todo, TodoUpdateDto dto) {
            TodoState.modifyDto(todo, dto);
        }

    };

    private static void modifyDto (Todo todo, TodoUpdateDto dto){
        todo.setDescription(dto.getDescription());
        todo.setTitle(dto.getTitle());
        todo.setTags(dto.getTags().stream().map(tag -> TodoTagsEnum.valueOf(tag.toUpperCase()))
//                        .map(Todo.TodoTagsEnum::valueOf)
                .collect(Collectors.toList()));
        todo.setPrevisionToEnd(dto.getPrevisionToEnd());
    }
//
//    // Métodos abstratos para cada operação
//    public abstract void start(Todo todo);
//
//    public abstract void complete(Todo todo);
//
//    public abstract void cancel(Todo todo);
}