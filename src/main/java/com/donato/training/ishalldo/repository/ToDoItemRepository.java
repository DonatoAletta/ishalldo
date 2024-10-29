package com.donato.training.ishalldo.repository;

import com.donato.training.ishalldo.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem,Long> {

    List<ToDoItem> findAllByUserId(Long id);

    List<ToDoItem> findByUser_Email(String email);

    Optional<ToDoItem> findByIdAndUser_Email(Long id, String email);

}
