package org.example.exo1rest.repository;

import org.example.exo1rest.entity.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo,Long> {

//@Query("SELECT c FROM to_do WHERE completed = 'true'")
//    List<ToDo> findByDoneTrue();

 List<ToDo> findByCompleted(boolean completed);

//    @Query()
//    List<ToDo> findByDoneFalse();

}
