package org.example.exo1rest.repository;

import org.example.exo1rest.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {


    List<ToDo> findByDoneTrue();
    List<ToDo> findByDoneFalse();

}
