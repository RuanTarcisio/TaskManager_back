package com.rtarcisio.todo_back.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoDto {
    private Long id_todo;

    private String title;

    private String description;
    
    private LocalDateTime toStart;

    private LocalDateTime finalized;

    private LocalDate previsionToEnd;

    private List<String> tags;
}
