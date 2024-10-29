package com.donato.training.ishalldo.service;

import com.donato.training.ishalldo.dto.ToDoItemDTO;
import com.donato.training.ishalldo.entity.ToDoItem;
import com.donato.training.ishalldo.mapper.ToDoItemMapper;
import com.donato.training.ishalldo.repository.ToDoItemRepository;
import com.donato.training.ishalldo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoItemService {

    private final ToDoItemRepository toDoItemRepository;
    private final ToDoItemMapper toDoItemMapper;
    private final UserRepository userRepository;

    public List<ToDoItemDTO> getAllTasks(Long id) {
        List<ToDoItem> toDoItemList = toDoItemRepository.findAllByUserId(id);
        return toDoItemList.stream().map(toDoItemMapper::toDoItemDTO).toList();
    }

    public ToDoItemDTO saveNewTask(Long userId, ToDoItem toDoItem) throws Exception{
        toDoItem.setUser(userRepository.findById(userId).orElseThrow(() -> new Exception("User with id: " + userId + " not found.")));
        toDoItem.setCreatedTime(LocalDateTime.now());
        toDoItem.setDueDate(LocalDateTime.now().plusDays(7));
        toDoItemRepository.save(toDoItem);
        return toDoItemMapper.toDoItemDTO(toDoItem);
    }

    public ToDoItemDTO updateTaskDetails(Long id, String field, String parameter, @AuthenticationPrincipal UserDetails userDetails) throws Exception {
        ToDoItem toDoItem = toDoItemRepository.findByIdAndUser_Email(id,userDetails.getUsername()).orElseThrow(() -> new Exception("No Task with id: " + id + " found for user: " + userDetails.getUsername()));
        switch (field) {
            case "title" -> toDoItem.setTitle(parameter);
            case "description" -> toDoItem.setDescription(parameter);
            default -> throw new Exception("No field found with name: " + field);
        }
        toDoItemRepository.save(toDoItem);
        return toDoItemMapper.toDoItemDTO(toDoItem);
    }

    public boolean deleteTask(Long id, UserDetails userDetails)throws Exception{
        ToDoItem toDoItem = toDoItemRepository.findByIdAndUser_Email(id,userDetails.getUsername()).orElseThrow(() -> new Exception("No Task with id: " + id + " found for user: " + userDetails.getUsername()));
        toDoItemRepository.delete(toDoItem);
        return true;
    }
}

