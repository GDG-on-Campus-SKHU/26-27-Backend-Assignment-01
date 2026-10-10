package com.gdg.restapi.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.time.LocalDate;
//내한 공연 온 아티스트 모음
@Getter
@AllArgsConstructor
public class Performancekr {
    private Long id;// 고유번호
    private String name;// 아티스트
    private String venue;// 공연장
    private String guest;// 게스트
    private LocalDate startDate;// 시작한날짜
    private LocalDate endDate;// 끝난 날짜

    public void update(String name, String venue, String guest, LocalDate startDate, LocalDate endDate) {
        if (name != null) {
            this.name = name;
        }
        if (venue != null) {
            this.venue = venue;
        }
        if (guest != null) {
            this.guest = guest;
        }
        if (startDate != null) {
            this.startDate = startDate;
        }
        if (endDate != null) {
            this.endDate = endDate;
        }
    }
}
