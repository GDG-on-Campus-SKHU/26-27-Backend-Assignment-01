package com.gdg.restapi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gdg.restapi.domain.Note;
import com.gdg.restapi.domain.Score;

import java.util.List;

@JsonPropertyOrder({"id", "name", "composer", "instrument", "melody"})
public record ScoreResponse(
        Long id, // 악보 id
        String name, // 악보 이름
        String composer, // 작곡가
        Integer instrument, // 악기
        List<Note> melody // 멜로디)
) {
    public ScoreResponse(Score score) {
        this(
                score.getId(),
                score.getName(),
                score.getComposer(),
                score.getInstrument(),
                // 방어적 복사 및 null일 시 빈 배열 반환
                (score.getMelody() != null) ? List.copyOf(score.getMelody()) : List.of()
        );
    }
}
