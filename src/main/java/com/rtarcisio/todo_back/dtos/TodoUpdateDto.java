package com.rtarcisio.todo_back.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoUpdateDto {

    @NotNull
    private String title;

    @NotNull
    private String description;

    private List<String> tags;

    private LocalDate previsionToEnd;
}
