package com.gdg.restapiexample.dto;

import lombok.Getter;

@Getter
public class TodoRequest {
    private String title;
    private boolean completed;
}
