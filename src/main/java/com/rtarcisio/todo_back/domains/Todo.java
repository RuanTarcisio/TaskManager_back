/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.rtarcisio.todo_back.domains;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.rtarcisio.todo_back.state.TodoState;

import com.rtarcisio.todo_back.strategy.TodoStateStrategyInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author ruantarcisio
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_todo;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private TodoState todoState;
    
    private LocalDateTime started;

    private LocalDateTime finalized;

    private LocalDate previsionToEnd;

    @ElementCollection(targetClass = TodoTagsEnum.class)
    @Enumerated(EnumType.STRING)
    private List<TodoTagsEnum> tags;

    public static enum TodoTagsEnum {
        React("React"), 
        HTML("HTML"), 
        CSS("CSS"), 
        Docker("Docker"), 
        Spring("Spring"), 
        JavaScript("JavaScript"), 
        Others("Others");

        private final String tag;

        TodoTagsEnum(String tag){
            this.tag =tag;
        }

        String getTag(){
            return tag;
        }    

    }
}