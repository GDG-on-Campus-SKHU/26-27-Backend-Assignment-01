package com.gdg.restapiexample.dto;

import lombok.Getter;

@Getter
public class TodoRequest {
    private Long id;
    private String title;
    private boolean completed;
}
