package org.example.exo1rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exo1rest.dto.ToDoResponseDTO;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;
    private String description;
    private LocalDate dueDate;
    private boolean completed;

    public ToDoResponseDTO entityToDto (){
        return ToDoResponseDTO.builder()
                .id(getId())
                .title(getTitle())
                .description(getDescription())
                .dueDate(getDueDate())
                .completed(false) // j'ai mis false par defaut
                .build();
    }
}
