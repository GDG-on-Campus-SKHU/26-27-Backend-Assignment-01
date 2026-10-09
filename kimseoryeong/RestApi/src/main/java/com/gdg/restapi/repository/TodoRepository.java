package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TodoRepository {
    private final Map<Long, Todo> todos = new HashMap<>();
    private long sequence = 0L;

    public TodoRepository() {
        save(new Todo(null, "Spring Boot 복습", "REST API 강의 노션 다시 읽기", "진행 전"));
        save(new Todo(null, "Postman 연습", "CRUD 요청 5개 보내보기", "진행 중"));
        save(new Todo(null, "과제 제출", "GitHub에 PR 올리기", "진행 전"));
    }

    public Todo save(Todo newTodo) {
        Todo todo = new Todo(++sequence, newTodo.getTitle(),
                newTodo.getContent(), newTodo.getStatus());
        todos.put(todo.getId(), todo);
        return todo;
    }

    public List<Todo> findAll() {
        return new ArrayList<>(todos.values());
    }

    public Optional<Todo> findById(Long id) {
        return Optional.ofNullable(todos.get(id));
    }

    public boolean delete(Long id) {
        return todos.remove(id) != null;
    }
}
