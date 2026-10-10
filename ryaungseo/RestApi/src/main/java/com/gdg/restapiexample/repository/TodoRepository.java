package com.gdg.restapiexample.repository;

import com.gdg.restapiexample.domain.Todo;
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
        save(new Todo(null, "고급파이썬 공부하기", true));
        save(new Todo(null, "과제 제출하기", false));
        save(new Todo(null, "운동하기", true));
    }

    public Todo save(Todo newTodo) {
        Todo todo = new Todo(
                ++sequence,
                newTodo.getTitle(),
                newTodo.isCompleted()
        );

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