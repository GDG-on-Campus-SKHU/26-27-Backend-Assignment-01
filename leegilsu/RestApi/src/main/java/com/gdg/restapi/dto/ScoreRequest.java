package com.gdg.restapi.dto;

import com.gdg.restapi.domain.Note;

import java.util.List;

public record ScoreRequest(
        String name, // 악보 이름
        String composer, // 작곡가
        Integer instrument, // 악기
        List<Note> melody // 멜로디
) {
}
