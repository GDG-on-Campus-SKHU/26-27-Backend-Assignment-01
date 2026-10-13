package com.gdg.restapi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gdg.restapi.domain.Music;

@JsonPropertyOrder({ "id", "number", "name", "singer", "lyricist", "composer" })
public record MusicResponse(
        Long id,
        String number,
        String name,
        String singer,
        String lyricist,
        String composer
) {
    public MusicResponse(Music music) {
        this(
                music.getId(),
                music.getNumber(),
                music.getName(),
                music.getSinger(),
                music.getLyricist(),
                music.getComposer()
        );
    }
}