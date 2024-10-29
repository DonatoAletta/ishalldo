package com.donato.training.ishalldo.repository;

import com.donato.training.ishalldo.entity.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoItemRepository extends JpaRepository<ToDoItem,Long> {
}
