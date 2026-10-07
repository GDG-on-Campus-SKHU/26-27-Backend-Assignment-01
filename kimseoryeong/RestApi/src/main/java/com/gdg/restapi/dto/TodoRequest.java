package com.gdg.restapi.dto;

import lombok.Getter;

@Getter
public class TodoRequest {
    private String title;
    private String content;
    private String status;
}