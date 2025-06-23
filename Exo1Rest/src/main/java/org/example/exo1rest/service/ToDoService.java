package org.example.exo1rest.service;

import org.example.exo1rest.dto.ToDoReceiveDTO;
import org.example.exo1rest.dto.ToDoResponseDTO;
import org.example.exo1rest.entity.ToDo;
import org.example.exo1rest.exeption.NotFoundException;
import org.example.exo1rest.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {

private final ToDoRepository toDoRepository;


    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public ToDoResponseDTO create (ToDoReceiveDTO toDoReceiveDTO) {
        return toDoRepository.save(toDoReceiveDTO.dtoToEntity()).entityToDto();
    }

    public ToDoResponseDTO getById(Long id) {
        return toDoRepository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<ToDoResponseDTO> getAll() {
        return toDoRepository.findAll().stream().map(ToDo::entityToDto).toList();
    }

    public void delete (Long id) {
        toDoRepository.deleteById(id);
    }

    public ToDoResponseDTO update (Long id, ToDoReceiveDTO toDoReceiveDTO) {
        ToDo toDofound = toDoRepository.findById(id).orElseThrow(NotFoundException::new);
        ToDo todoGet = toDoReceiveDTO.dtoToEntity();
        toDofound.setTitle(todoGet.getTitle());
        toDofound.setDescription(todoGet.getDescription());
        toDofound.setDueDate(todoGet.getDueDate());
        toDofound.setDone(todoGet.isDone());
        return toDoRepository.save(toDofound).entityToDto();
    }
    public List<ToDoResponseDTO> searchTaskDone() {
        return toDoRepository
                .findByDoneTrue()
                .stream()
                .map(ToDo::entityToDto)
                .collect(Collectors.toList());
    }

    public List<ToDoResponseDTO> searchTaskNotDone() {
        return toDoRepository
                .findByDoneFalse()
                .stream()
                .map(ToDo::entityToDto)
                .collect(Collectors.toList());
    }

}