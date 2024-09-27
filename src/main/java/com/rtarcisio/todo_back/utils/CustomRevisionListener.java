package com.rtarcisio.todo_back.utils;

import com.rtarcisio.todo_back.domains.CustomRevisionEntity;
import org.hibernate.envers.RevisionListener;
import org.springframework.stereotype.Component;

@Component
public class CustomRevisionListener implements RevisionListener {
    @Override
    public void newRevision(Object revisionEntity) {
        CustomRevisionEntity customRevisionEntity = (CustomRevisionEntity) revisionEntity;
        String username = "Ruan";     //UserContext.getCurrentUsername();
        customRevisionEntity.setUsername(username);
    }
}