package com.gdg.restapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class TodoRequest {
    @NotBlank(message = "제목은 필수입니다.")
    private String title;
    private String content;
    private String status;
}