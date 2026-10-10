package com.gdg.restapiexample.dto;

import com.gdg.restapiexample.domain.Todo;
import lombok.Getter;

@Getter
public class TodoResponse {
    private final Long id;
    private final String title;
    private final boolean completed;

    public TodoResponse(Todo todo){
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.completed = todo.isCompleted();

    }
}
