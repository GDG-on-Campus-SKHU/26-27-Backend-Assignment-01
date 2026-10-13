package com.gdg.restapi.dto;

public record MusicRequest(
        String number,
        String name,
        String singer,
        String lyricist,
        String composer
) {
}
