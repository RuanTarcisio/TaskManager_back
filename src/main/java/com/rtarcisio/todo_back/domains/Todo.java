/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rtarcisio.todo_back.domains;

import com.rtarcisio.todo_back.dtos.TodoUpdateDto;
import com.rtarcisio.todo_back.enums.TodoTagsEnum;
import com.rtarcisio.todo_back.state.TodoState;
import com.rtarcisio.todo_back.utils.TodoTagsConverter;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ruantarcisio
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_todo;

    @Audited
    private String title;

    @Audited
    private String description;

    @Audited
    @Enumerated(EnumType.STRING)
    private TodoState todoState = TodoState.NEW;

    private LocalDateTime started;

    @Audited
    private LocalDateTime finalized;

    @Audited
    @LastModifiedDate
    @Column(name = "modified_at")
    private LocalDateTime modifiedAt;

    @Audited
    private LocalDate previsionToEnd;

    @Audited
    @Convert(converter = TodoTagsConverter.class) // Aplica o conversor
    private List<TodoTagsEnum> tags;

    public void reOpen() {
        this.todoState.reOpen(this);
    }

    public void complete() {
        this.todoState.complete(this);
    }

    public void cancel() {
        this.todoState.cancel(this);
    }

    public void edit(TodoUpdateDto dto) {
        this.todoState.edit(this, dto);
    }


}