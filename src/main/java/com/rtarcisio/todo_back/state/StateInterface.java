package com.rtarcisio.todo_back.state;

import com.rtarcisio.todo_back.domains.Todo;
import com.rtarcisio.todo_back.dtos.TodoUpdateDto;

public interface StateInterface {
    void reOpen(Todo todo);
    void complete(Todo todo);
    void close(Todo todo);
    void edit(Todo todo, TodoUpdateDto dto);

}
