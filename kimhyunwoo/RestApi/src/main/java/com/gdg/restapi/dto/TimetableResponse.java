package com.gdg.restapi.dto;

import com.gdg.restapi.domain.Timetable;
import lombok.Getter;

@Getter
public class TimetableResponse {
    private final Long id;
    private final String name;
    private final String day;

    public TimetableResponse(Timetable timetable) {
        this.id = timetable.getId();
        this.name = timetable.getName();
        this.day = timetable.getDay();
    }
}
