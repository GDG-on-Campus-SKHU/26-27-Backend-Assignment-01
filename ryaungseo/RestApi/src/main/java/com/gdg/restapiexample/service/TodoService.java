package com.gdg.restapiexample.service;

import com.gdg.restapiexample.domain.Todo;
import com.gdg.restapiexample.dto.TodoRequest;
import com.gdg.restapiexample.dto.TodoResponse;
import com.gdg.restapiexample.repository.StudentRepository;
import com.gdg.restapiexample.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoResponse create(TodoRequest request) {
        Todo todo = new Todo(null, request.getTitle(), request.isCompleted());

        return new
                TodoResponse(todoRepository.save(todo));
    }

    public TodoResponse update(Long id, TodoRequest request) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일입니다."));

        todo.update(request.getTitle(), request.isCompleted());

        return new TodoResponse(todo);
    }


    public void delete(Long id) {
        if (!todoRepository.delete(id)) {
            throw new IllegalArgumentException("존재하지 않는 할 일입니다.");
        }
    }

    public TodoResponse findById(Long id) {
        return new TodoResponse(todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일입니다.")));
    }

    public List<TodoResponse> findAll() {
        return todoRepository.findAll().stream()
                .map(TodoResponse::new)
                .toList();
    }
}




