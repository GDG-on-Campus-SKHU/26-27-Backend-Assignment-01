package com.gdg.restapi.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Note {
    private final List<Integer> pitches; // MiDI 노트 번호
    private final Integer duration; // 유지 시간(밀리초)

    public Note(List<Integer> pitches, Integer duration) {
        // 방어적 복사 및 null일 시 빈 배열 반환
        this.pitches = (pitches != null) ? List.copyOf(pitches) : List.of();
        this.duration = duration;
    }
}
