package com.rtarcisio.todo_back.repositories;

import com.rtarcisio.todo_back.domains.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
