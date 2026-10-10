package com.gdg.restapiexample.controller;

import com.gdg.restapiexample.dto.TodoRequest;
import com.gdg.restapiexample.dto.TodoResponse;
import com.gdg.restapiexample.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable("id") Long id,
                                               @RequestBody TodoRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body((TodoResponse) todoService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        todoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}