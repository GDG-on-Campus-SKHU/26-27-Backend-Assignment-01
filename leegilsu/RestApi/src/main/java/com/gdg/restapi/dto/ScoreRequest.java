package com.gdg.restapi.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ScoreRequest {
    private String name; // 악보 이름
    private String composer; // 작곡가
    private Integer instrument; // 악기
    private List<Note> melody; // 멜로디
}
