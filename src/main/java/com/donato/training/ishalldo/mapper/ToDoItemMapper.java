package com.donato.training.ishalldo.mapper;

import com.donato.training.ishalldo.dto.ToDoItemDTO;
import com.donato.training.ishalldo.entity.ToDoItem;
import org.springframework.stereotype.Component;

@Component
public class ToDoItemMapper {

    public ToDoItem toDoItem(ToDoItemDTO toDoItemDTO){
        ToDoItem toDoItem = new ToDoItem();
        toDoItem.setTitle(toDoItemDTO.getTitle());
        toDoItem.setDescription(toDoItemDTO.getDescription());
        toDoItem.setComplete(toDoItemDTO.isComplete());
        toDoItem.setCreatedTime(toDoItemDTO.getCreatedTime());
        toDoItem.setDueDate(toDoItemDTO.getDueDate());
        toDoItem.setPriorityLevel(toDoItemDTO.getPriorityLevel());
        return toDoItem;
    }

    public ToDoItemDTO toDoItemDTO(ToDoItem toDoItem){
        ToDoItemDTO toDoItemDTO = new ToDoItemDTO();
        toDoItemDTO.setTitle(toDoItem.getTitle());
        toDoItemDTO.setDescription(toDoItem.getDescription());
        toDoItemDTO.setComplete(toDoItem.isComplete());
        toDoItemDTO.setCreatedTime(toDoItem.getCreatedTime());
        toDoItemDTO.setDueDate(toDoItem.getDueDate());
        toDoItemDTO.setPriorityLevel(toDoItem.getPriorityLevel());
        return toDoItemDTO;

    }
}
