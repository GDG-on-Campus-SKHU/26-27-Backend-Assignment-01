package com.gdg.restapi.domain;

import lombok.Getter;

import java.util.List;

@Getter
public class Score {
    private final Long id; // 악보 id
    private String name; // 악보 이름
    private String composer; // 작곡가
    private Integer instrument; // 악기
    private List<Note> melody; // pitches, duration 저장 리스트

    public Score(Long id, String name, String composer, Integer instrument, List<Note> melody) {
        validateName(name);
        validateInstrument(instrument);

        this.id = id;
        this.name = name;
        this.composer = composer;
        this.instrument = instrument;
        this.melody = (melody != null) ? List.copyOf(melody) : List.of(); // 방어적 복사, null 시 빈 배열 저장
    }

    public void update(String name, String composer, Integer instrument, List<Note> melody) {
        if (name != null) validateName(name);
        validateInstrument(instrument);

        if (name != null) this.name = name;
        if (composer != null) this.composer = composer;
        if (instrument != null) this.instrument = instrument;
        if (melody != null) this.melody = List.copyOf(melody); // 불변 리스트로 교체
    }

    // 악보명 유효성 검사 (null, 공백 허용X)
    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("악보명을 작성해주세요.");
        }
    }

    // 악기 번호 유효성 검사 (0 ~ 127 범위 벗어남 허용X)
    private void validateInstrument(Integer instrument) {
        if (instrument != null && (instrument < 0 || 127 < instrument)) {
            throw new IllegalArgumentException("악기 번호는 0 ~ 127 입니다.");
        }
    }
}
