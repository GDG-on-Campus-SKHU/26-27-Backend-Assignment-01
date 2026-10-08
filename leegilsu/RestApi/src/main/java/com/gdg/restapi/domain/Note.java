package com.gdg.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Note {
    private List<Integer> pitches; // MiDI 노트 번호
    private Integer duration; // 유지 시간(밀리초)
}
