package com.rtarcisio.todo_back.dtos;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotNull;
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

    @NotNull
    private String title;

    @NotNull
    private String description;
    
    private LocalDateTime started;

    private LocalDateTime finalized;

    private LocalDate previsionToEnd;

    @NotNull
    private List<String> tags;

    private String state;
}
