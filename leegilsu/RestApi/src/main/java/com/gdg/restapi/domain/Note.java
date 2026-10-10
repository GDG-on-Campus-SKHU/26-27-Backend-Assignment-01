package com.gdg.restapi.domain;

import java.util.List;

// pitches: MiDI 노트 번호, duration: 유지 시간(밀리초)
public record Note(List<Integer> pitches, Integer duration) {

    // 컴팩트 생성자로 파라미터 생략
    public Note {
        pitches = (pitches != null) ? List.copyOf(pitches) : List.of(); // 방어적 복사 및 null일 시 빈 배열 반환
    }
}
