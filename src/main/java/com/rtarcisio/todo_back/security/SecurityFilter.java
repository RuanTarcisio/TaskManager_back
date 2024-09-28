package com.rtarcisio.todo_back.security;


import com.rtarcisio.todo_back.domains.Person;
import com.rtarcisio.todo_back.repositories.PersonRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    
    final TokenService tokenService;
    
    final PersonRepository personRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if(token != null){

           try {
               var login = tokenService.validateToken(token);

               Person user = personRepository.findByEmail(login).orElseThrow(() -> new NoSuchElementException("Usuario nao encontrado "));
               UserDetails userDetails = new CustomUserDetails(user.getId(), user.getEmail(), user.getNomeCompleto(), user.getRole().name());


               var authentication = new UsernamePasswordAuthenticationToken(user, null, userDetails.getAuthorities());
               SecurityContextHolder.getContext().setAuthentication(authentication);
           }catch (Exception e){
               System.out.println("estou aqui");
           }
        }
        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(authHeader == null) return null;
        return authHeader.replace("Bearer ", "");
    }
}
