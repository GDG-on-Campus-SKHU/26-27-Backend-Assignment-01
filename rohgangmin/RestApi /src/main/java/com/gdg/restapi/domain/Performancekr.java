package com.gdg.restapi.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
//내한 공연 온 아티스트 모음

public class Performancekr {
    private Long id;
    private String name;//아티스트
    private String venue;//공연장
    private String guest;//게스트
    private String date;//날짜

    public void update(String name, String venue, String guest, String date) {
        if (name != null) {
            this.name = name;
        }
        if (venue != null) {
            this.venue = venue;
        }
        if (guest != null) {
            this.guest = guest;
        }
        if (date != null) {
            this.date = date;
        }
    }


}
