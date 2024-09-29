package com.rtarcisio.todo_back.repositories;


import com.rtarcisio.todo_back.domains.Foto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface FotoRepository extends JpaRepository<Foto, String> {

//    @Query("SELECT f FROM Foto f WHERE f.person.id = :personId")
//    Optional <Foto> findByPersonId(Long personId);
}
