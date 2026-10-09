package com.gdg.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Music {
    private Long id;
    private String number;
    private String name;
    private String singer;
    private String lyricist;
    private String composer;

    public void update(String number, String name, String singer, String lyricist, String composer) {
        if (number != null) {
            this.number = number;
        }
        if (name != null) {
            this.name = name;
        }
        if (singer != null) {
            this.singer = singer;
        }
        if (lyricist != null) {
            this.lyricist = lyricist;
        }
        if (composer != null) {
            this.composer = composer;
        }
    }
}
