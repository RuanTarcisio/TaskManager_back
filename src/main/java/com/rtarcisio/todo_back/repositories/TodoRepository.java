package com.rtarcisio.todo_back.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rtarcisio.todo_back.domains.Todo;

/**
 *
 * @author ruantarcisio
 */
public interface TodoRepository extends  JpaRepository<Todo, Long>{

}
