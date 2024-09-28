package com.rtarcisio.todo_back.controller;

import com.rtarcisio.todo_back.domains.Person;
import com.rtarcisio.todo_back.dtos.input.UsuarioInput;
import com.rtarcisio.todo_back.dtos.PersonDto;
import com.rtarcisio.todo_back.services.PersonService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/usuarios")
@Validated
public class UsuarioController {

    @Autowired
    private PersonService personService;

    @Transactional
    @PostMapping(value = "/cadastrar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> salvarUsuario(@Valid UsuarioInput usuarioInput) throws IOException {

        Person person = personService.savePerson(usuarioInput);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PersonDto> findPersonById(@PathVariable Long id) {

        PersonDto dto = personService.buscarPorId(id);

        return ResponseEntity.ok(dto);
    }
}
