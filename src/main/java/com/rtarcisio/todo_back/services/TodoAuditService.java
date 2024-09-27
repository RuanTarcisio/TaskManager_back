package com.rtarcisio.todo_back.services;

import com.rtarcisio.todo_back.domains.Todo;
import com.rtarcisio.todo_back.resources.TodoRepository;
import jakarta.persistence.EntityManager;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoAuditService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    private TodoRepository repository;


    public List<Todo> getAuditHistory(Long todoId) {

        Todo todo = repository.findById(todoId).orElseThrow(() -> new RuntimeException());
        AuditReader auditReader = AuditReaderFactory.get(entityManager);

        // Obtem todas as versões da entidade 'Todo' pelo ID
        List<Todo> auditHistory = auditReader.createQuery()
                .forRevisionsOfEntity(Todo.class, true, true)
                .add(AuditEntity.id().eq(todoId))
                .getResultList();

        return auditHistory;
    }
}
