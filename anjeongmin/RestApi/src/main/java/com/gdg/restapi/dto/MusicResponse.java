package com.gdg.restapi.dto;

import com.gdg.restapi.domain.Music;
import lombok.Getter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Getter
@JsonPropertyOrder({ "id", "number", "name", "singer", "lyricist", "composer" })
public class MusicResponse {
    private final Long id;
    private final String number;
    private final String name;
    private final String singer;
    private final String lyricist;
    private final String composer;

    public MusicResponse(Music music) {
        this.id = music.getId();
        this.number = music.getNumber();
        this.name = music.getName();
        this.singer = music.getSinger();
        this.lyricist = music.getLyricist();
        this.composer = music.getComposer();
    }
}
