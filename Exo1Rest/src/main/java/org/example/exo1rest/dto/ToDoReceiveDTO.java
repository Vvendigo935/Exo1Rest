package org.example.exo1rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo1rest.entity.ToDo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ToDoReceiveDTO {

    private String title;
    private String description;
    private String dueDateString;
    private String isDoneString;

public ToDo dtoToEntity() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    return ToDo.builder().title(getTitle()).description(getDescription())
            .dueDate(LocalDate.parse(getDueDateString(), formatter)).isDone(Boolean.parseBoolean(getIsDoneString())).build(); // c'est moi qui ai fait ça ?
}
}
