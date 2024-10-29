package com.donato.training.ishalldo.dto;

import com.donato.training.ishalldo.enumerators.Priority;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoItemDTO {

    private String title;
    private String description;
    private boolean isComplete;
    private LocalDateTime createdTime;
    private LocalDateTime dueDate;
    private Priority priorityLevel;
}
