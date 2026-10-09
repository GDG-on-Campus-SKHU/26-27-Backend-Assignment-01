package com.gdg.restapi.dto;

import lombok.Getter;

@Getter
public class TodoUpdateRequest {
    private String title;
    private String content;
    private String status;

    private boolean titlePresent;
    private boolean contentPresent;
    private boolean statusPresent;

    public void setTitle(String title) {
        this.title = title;
        this.titlePresent = true;
    }

    public void setContent(String content) {
        this.content = content;
        this.contentPresent = true;
    }

    public void setStatus(String status) {
        this.status = status;
        this.statusPresent = true;
    }
}
