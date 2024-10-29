package com.donato.training.ishalldo.service;

import com.donato.training.ishalldo.dto.ToDoItemDTO;
import com.donato.training.ishalldo.entity.ToDoItem;
import com.donato.training.ishalldo.mapper.ToDoItemMapper;
import com.donato.training.ishalldo.repository.ToDoItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoItemService {

    private final ToDoItemRepository toDoItemRepository;
    private final ToDoItemMapper toDoItemMapper;


    public List<ToDoItemDTO> getAllTasks() {
        List<ToDoItem> toDoItemList = toDoItemRepository.findAll();
        return toDoItemList.stream().map(toDoItemMapper::toDoItemDTO).toList();
    }

    public ToDoItemDTO saveNewTask(ToDoItem toDoItem) {
        toDoItemRepository.save(toDoItem);
        return toDoItemMapper.toDoItemDTO(toDoItem);
    }

    public ToDoItemDTO updateTaskDetails(Long id, String field, String parameter) throws Exception {
        ToDoItem toDoItem = toDoItemRepository.findById(id).orElseThrow(() -> new Exception("ToDoItem not found"));
        switch (field) {
            case "title" -> toDoItem.setTitle(parameter);
            case "description" -> toDoItem.setDescription(parameter);
            default -> throw new Exception("No field found with name: " + field);
        }
        toDoItemRepository.save(toDoItem);
        return toDoItemMapper.toDoItemDTO(toDoItem);
    }

    public boolean deleteTask(Long id){
        toDoItemRepository.deleteById(id);
        return true;
    }
}

