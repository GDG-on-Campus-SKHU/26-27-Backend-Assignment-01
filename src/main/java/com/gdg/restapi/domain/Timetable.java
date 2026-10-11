package com.gdg.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor

public class Timetable {
    private long id;
    private String day;
    private String name;

    public void update(String day, String name) {
        if (day != null) {
            this.day = day;
        }
        if (name != null) {
            this.name = name;
        }

    }
}
