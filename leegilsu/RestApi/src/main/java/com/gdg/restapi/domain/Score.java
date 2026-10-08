package com.gdg.restapi.domain;

import com.gdg.restapi.dto.Note;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Score {
    private Long id; // 악보 id
    private String name; // 악보 이름
    private String composer; // 작곡가
    private Integer instrument; // 악기
    private List<Note> melody; // pitches, duration 저장 리스트

    public void update(String name, String composer, Integer instrument, List<Note> melody) {
        if (name != null) {
            this.name = name;
        }
        if (composer != null) {
            this.composer = composer;
        }
        if (instrument != null) {
            this.instrument = instrument;
        }
        if (melody != null) {
            this.melody = melody;
        }
    }
}
