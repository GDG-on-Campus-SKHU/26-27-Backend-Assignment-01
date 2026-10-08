package com.gdg.restapi.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Note {
    private List<Integer> pitches; // MiDI 노트 번호
    private Integer duration; // 유지 시간(밀리초)

    public Note(List<Integer> pitches, Integer duration) {
        this.pitches = pitches;
        this.duration = duration;
    }
}
