package com.gdg.restapiexample.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Todo {

    private Long id;
    private String title;
    private Boolean completed;

    public void update(String title, Boolean completed) {
        if (title != null) {
            this.title = title;
        }

        if (completed != null) {
            this.completed = completed;
        }
    }
}
//수정

