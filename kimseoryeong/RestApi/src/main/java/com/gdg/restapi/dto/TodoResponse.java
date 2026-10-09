package com.gdg.restapi.dto;

import com.gdg.restapi.domain.Todo;
import lombok.Getter;

@Getter
public class TodoResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String status;

    public TodoResponse(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.status = todo.getStatus();
    }
}
