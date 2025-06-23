package org.example.exo1rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ToDoResponseDTO {

    private long id;
    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;





}
