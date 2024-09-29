package com.rtarcisio.todo_back.security;

import com.rtarcisio.todo_back.domains.Person;
import com.rtarcisio.todo_back.repositories.PersonRepository;
import com.rtarcisio.todo_back.services.exceptions.UsuarioNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService implements UserDetailsService {

    @Autowired
    PersonRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = repository.findByEmail(username).orElseThrow(() -> new UsuarioNaoEncontradoException("User not found"));
        UserDetails userDetails = new CustomUserDetails(person.getId(), person.getEmail(), person.getName(), person.getRole().name(), person.getPasswd());

        return userDetails;
    }
}
