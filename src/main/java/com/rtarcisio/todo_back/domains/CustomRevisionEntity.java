package com.rtarcisio.todo_back.domains;

import jakarta.persistence.Entity;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Entity
@RevisionEntity // Esta classe armazena informações sobre revisões
public class CustomRevisionEntity extends DefaultRevisionEntity {
    private String username; // Armazenar o nome do usuário que fez a alteração

    // Getters e Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}