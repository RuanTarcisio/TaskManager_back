package com.rtarcisio.todo_back.state;

import com.rtarcisio.todo_back.domains.Todo;
import com.rtarcisio.todo_back.dtos.TodoUpdateDto;

public interface StateInterface {
    void reOpen(Todo todo) throws UnsupportedOperationException;
    void complete(Todo todo) throws UnsupportedOperationException;
    void cancel(Todo todo) throws UnsupportedOperationException;
    void edit(Todo todo, TodoUpdateDto dto) throws UnsupportedOperationException;

}
