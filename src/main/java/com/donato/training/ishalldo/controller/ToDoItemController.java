package com.donato.training.ishalldo.controller;

import com.donato.training.ishalldo.dto.ToDoItemDTO;
import com.donato.training.ishalldo.service.ToDoItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class ToDoItemController {

    private final ToDoItemService toDoItemService;

    @GetMapping("/all")
    public ResponseEntity<List<ToDoItemDTO>> getAllToDoItems() {
        List<ToDoItemDTO> toDoItemDTOList = toDoItemService.getAllTasks();
        return ResponseEntity.status(HttpStatus.OK).body(toDoItemDTOList);
    }


}
