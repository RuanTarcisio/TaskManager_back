/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rtarcisio.todo_back.domains;

import com.rtarcisio.todo_back.dtos.TodoUpdateDto;
import com.rtarcisio.todo_back.state.TodoState;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

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
@Audited
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_todo;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TodoState todoState = TodoState.NEW;

    private LocalDateTime started;

    private LocalDateTime finalized;

    private LocalDateTime modificationDate;

    private LocalDate previsionToEnd;

    @ElementCollection(targetClass = TodoTagsEnum.class)
    @Enumerated(EnumType.STRING)
    private List<TodoTagsEnum> tags;

    public void reOpen() {
        this.todoState.reOpen(this);
    }

    public void complete() {
        this.todoState.complete(this);
    }

    public void cancel() {
        this.todoState.close(this);
    }

    public void edit(TodoUpdateDto dto) {
        this.todoState.edit(this, dto);
    }

    public enum TodoTagsEnum {
        React("React"),
        HTML("HTML"),
        CSS("CSS"),
        Docker("Docker"),
        Spring("Spring"),
        JavaScript("JavaScript"),
        Others("Others");

        private final String tag;

        TodoTagsEnum(String tag) {
            this.tag = tag;
        }

        String getTag() {
            return tag;
        }

    }

}