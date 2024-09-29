package com.rtarcisio.todo_back.controller;


import com.rtarcisio.todo_back.domains.Person;
import com.rtarcisio.todo_back.dtos.AuthenticationDTO;
import com.rtarcisio.todo_back.dtos.LoginResponseDTO;
import com.rtarcisio.todo_back.repositories.PersonRepository;
import com.rtarcisio.todo_back.security.CustomUserDetails;
import com.rtarcisio.todo_back.security.TokenService;
import com.rtarcisio.todo_back.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
@Validated
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final TokenService tokenService;

    private final PersonRepository repository;

    private final PersonService service;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager, TokenService tokenService, PersonRepository repository, PersonService service) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
        this.repository = repository;
        this.service = service;
    }

    @PostMapping()
    public ResponseEntity login(@Valid @RequestBody AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((CustomUserDetails)auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}
