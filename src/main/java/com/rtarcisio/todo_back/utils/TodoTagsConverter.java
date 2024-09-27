package com.rtarcisio.todo_back.utils;

import com.rtarcisio.todo_back.enums.TodoTagsEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter(autoApply = true)
public class TodoTagsConverter implements AttributeConverter<List<TodoTagsEnum>, String> {

    @Override
    public String convertToDatabaseColumn(List<TodoTagsEnum> tags) {
        if (tags == null || tags.isEmpty()) {
            return "";
        }
        return tags.stream()
                .map(Enum::name) // Converte os enums para suas representações em string
                .collect(Collectors.joining(",")); // Junta em uma única string
    }

    @Override
    public List<TodoTagsEnum> convertToEntityAttribute(String tagsString) {
        if (tagsString == null || tagsString.isEmpty()) {
            return List.of(); // Retorna uma lista vazia
        }
        return Arrays.stream(tagsString.split(","))
                .map(TodoTagsEnum::valueOf) // Converte as strings de volta para enums
                .collect(Collectors.toList());
    }
}