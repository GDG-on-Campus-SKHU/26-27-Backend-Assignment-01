package com.gdg.restapi.service;

import com.gdg.restapi.domain.Todo;
import com.gdg.restapi.dto.TodoRequest;
import com.gdg.restapi.dto.TodoResponse;
import com.gdg.restapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoResponse create(TodoRequest request) {
        Todo todo = new Todo(null, request.getTitle(), request.getContent(), request.getStatus());
        return new TodoResponse(todoRepository.save(todo));
    }

    public List<TodoResponse> findAll() {
        return todoRepository.findAll().stream()
                .map(TodoResponse::new)
                .toList();
    }

    public TodoResponse findById(Long id) {
        return new TodoResponse(todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일입니다.")));
    }

    public TodoResponse update(Long id, TodoRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일입니다."));

        todo.update(request.getTitle(), request.getContent(), request.getStatus());
        return new TodoResponse(todo);
    }

    public void delete(Long id) {
        if (!todoRepository.delete(id)) {
            throw new IllegalArgumentException("존재하지 않는 할 일입니다.");
        }
    }
}