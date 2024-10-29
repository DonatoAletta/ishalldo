package com.donato.training.ishalldo.entity;

import com.donato.training.ishalldo.enumerators.Priority;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity(name = "item")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ToDoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String title;

    @Setter
    private String description;

    @Setter
    private boolean isComplete = false;

    @Setter
    private LocalDateTime createdTime;

    @Setter
    private LocalDateTime dueDate;

    @Setter
    @Enumerated(EnumType.STRING)
    private Priority priorityLevel = Priority.LOW;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
