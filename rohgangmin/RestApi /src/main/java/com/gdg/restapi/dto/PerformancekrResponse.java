package com.gdg.restapi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gdg.restapi.domain.Performancekr;
import java.time.LocalDate;

@JsonPropertyOrder({ "id", "name", "venue","guest","date" })
public record PerformancekrResponse (
        Long id,// 고유번호
        String name,// 아티스트
        String venue,// 공연장
        String guest,// 게스트
        LocalDate startDate,// 시작일
        LocalDate endDate// 종료일
) {
    public PerformancekrResponse(Performancekr performancekr) {
        this(performancekr.getId(), performancekr.getName(), performancekr.getVenue(), performancekr.getGuest(), performancekr.getStartDate(), performancekr.getEndDate());

    }
}
