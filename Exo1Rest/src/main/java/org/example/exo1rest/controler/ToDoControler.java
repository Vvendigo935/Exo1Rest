package org.example.exo1rest.controler;

import org.example.exo1rest.dto.ToDoReceiveDTO;
import org.example.exo1rest.dto.ToDoResponseDTO;
import org.example.exo1rest.service.ToDoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo")
public class ToDoControler {
private ToDoService toDoService;

public ToDoControler(ToDoService toDoService) {
    this.toDoService = toDoService;
}
@GetMapping
    public ResponseEntity<List<ToDoResponseDTO>> findAll() {
    return ResponseEntity.ok(toDoService.getAll());
}
@GetMapping("/{id}")
public ResponseEntity<ToDoResponseDTO> findById(@PathVariable Long id) {
    return ResponseEntity.ok(toDoService.getById(id));
}
@PostMapping
    public ResponseEntity<ToDoResponseDTO> create (@RequestBody ToDoReceiveDTO toDoReceiveDTO) {
    return ResponseEntity.status(HttpStatus.CREATED).body(toDoService.create(toDoReceiveDTO));
}
@PutMapping("/{id}")
    public ResponseEntity<ToDoResponseDTO> update (@PathVariable Long id, @RequestBody ToDoReceiveDTO toDoReceiveDTO) {
    return ResponseEntity.ok(toDoService.update(id, toDoReceiveDTO));
}
@DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable Long id) {
    toDoService.delete(id);
    return ResponseEntity.ok(String.format("Deleted todo : %s", id));
}


}
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> delte(@PathVariable long id){
//        service.delete(id);
//        return ResponseEntity.ok(String.format("User at id : %s is deleted",id));
//    }