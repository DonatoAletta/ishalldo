package com.donato.training.ishalldo.controller;

import com.donato.training.ishalldo.dto.ToDoItemDTO;
import com.donato.training.ishalldo.entity.ToDoItem;
import com.donato.training.ishalldo.enumerators.Priority;
import com.donato.training.ishalldo.service.ToDoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ToDoItemController {

    private final ToDoItemService toDoItemService;

    @GetMapping("/user/all/{userId}")
    public ResponseEntity<List<ToDoItemDTO>> getAllToDoItems(@PathVariable("userId") Long userId) {
        List<ToDoItemDTO> toDoItemDTOList = toDoItemService.getAllTasks(userId);
        return ResponseEntity.status(HttpStatus.OK).body(toDoItemDTOList);
    }

    @PostMapping("/user/task/{userId}")
    public ResponseEntity<?> addNewTask(@PathVariable("userId") Long userId, @RequestBody ToDoItem toDoItem) {
        try {
            ToDoItemDTO toDoItemDTO = toDoItemService.saveNewTask(userId, toDoItem);
            return ResponseEntity.status(HttpStatus.OK).body(toDoItemDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/user/task/destroy/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable("taskId") Long taskId, @AuthenticationPrincipal UserDetails userDetails) {
        try {
            boolean result = toDoItemService.deleteTask(taskId, userDetails);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/user/details/{taskId}")
    public ResponseEntity<?> updateTaskDetails(@PathVariable("taskId") Long taskId,
                                               @AuthenticationPrincipal UserDetails userDetails,
                                               @RequestParam String field,
                                               @RequestParam String parameter) {
        try {
            ToDoItemDTO toDoItemDTO = toDoItemService.updateTaskDetails(taskId, field, parameter, userDetails);
            return ResponseEntity.status(HttpStatus.OK).body(toDoItemDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/user/priority/{taskId}")
    public ResponseEntity<?> setPriorityLevel(@PathVariable("taskId") Long taskId,
                                              @AuthenticationPrincipal UserDetails userDetails,
                                              @RequestParam Priority priority) {
        try{
            ToDoItemDTO toDoItemDTO = toDoItemService.setPriorityLevel(taskId,userDetails,priority);
            return ResponseEntity.status(HttpStatus.OK).body(toDoItemDTO);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PatchMapping("/user/complete/{taskId}")
    public ResponseEntity<?> setCompleteStatus(@PathVariable("taskId") Long taskId,
                                               @AuthenticationPrincipal UserDetails userDetails,
                                               @RequestParam boolean value) {
        try {
            ToDoItemDTO todoItem = toDoItemService.setCompleteStatus(taskId, userDetails, value);
            return ResponseEntity.status(HttpStatus.OK).body(todoItem);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
