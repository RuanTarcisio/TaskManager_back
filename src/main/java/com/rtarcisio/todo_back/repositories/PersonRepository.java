package com.rtarcisio.todo_back.repositories;

import com.rtarcisio.todo_back.domains.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String login);

    Optional<Person> findByCpf(String cpf);
}
