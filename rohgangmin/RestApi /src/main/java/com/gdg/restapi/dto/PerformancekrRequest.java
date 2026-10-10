package com.gdg.restapi.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.gdg.restapi.domain.Performancekr;
import java.time.LocalDate;

@JsonPropertyOrder({"name", "venue","guest","startDate","endDate" })
public record PerformancekrRequest (
        String name,// 아티스트
        String venue,// 공연장
        String guest,// 게스트
        LocalDate startDate, // 시작일
        LocalDate endDate // 종료일
) {
    public PerformancekrRequest(Performancekr performancekr) {
        this(performancekr.getName(), performancekr.getVenue(), performancekr.getGuest(), performancekr.getStartDate(),performancekr.getEndDate());
    }
}
