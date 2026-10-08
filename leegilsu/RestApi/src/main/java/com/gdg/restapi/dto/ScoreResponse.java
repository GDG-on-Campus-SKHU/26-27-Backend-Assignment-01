package com.gdg.restapi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gdg.restapi.domain.Score;
import lombok.Getter;

import java.util.List;

@Getter
@JsonPropertyOrder({"id", "name", "composer", "instrument", "melody"})
public class ScoreResponse {
    private final Long id; // 악보 id
    private final String name; // 악보 이름
    private final String composer; // 작곡가
    private final Integer instrument; // 악기
    private final List<Note> melody; // 멜로디

    public ScoreResponse(Score score) {
        this.id = score.getId();
        this.name = score.getName();
        this.composer = score.getComposer();
        this.instrument = score.getInstrument();
        this.melody = score.getMelody();
    }
}
