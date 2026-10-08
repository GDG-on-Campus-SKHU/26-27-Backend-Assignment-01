package com.gdg.restapi.dto;

import com.gdg.restapi.domain.Performancekr;
import lombok.Getter;

@Getter

public class PerformancekrResponse {
    private final Long id;
    private final String name;
    private final String venue;
    private final String guest;
    private final String date;

    public PerformancekrResponse(Performancekr performancekr) {
        this.id = performancekr.getId();
        this.name = performancekr.getName();
        this.venue = performancekr.getVenue();
        this.guest = performancekr.getGuest();
        this.date = performancekr.getDate();

    }
}
