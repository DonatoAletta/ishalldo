package com.donato.training.ishalldo.entity;

import com.donato.training.ishalldo.enumerators.Priority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity(name = "item")
@Getter
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String title;

    @Setter
    private String description;

    @Setter
    private boolean isComplete;

    @Setter
    private LocalDateTime createdTime;

    @Setter
    private LocalDateTime dueDate;

    @Setter
    @Enumerated(EnumType.STRING)
    private Priority priorityLevel;
}
