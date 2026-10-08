package com.gdg.restapi.dto;

import lombok.Getter;

@Getter
public class PerformancekrRequest {
    private Long id;
    private String name;//아티스트
    private String venue;//공연장
    private String guest;//게스트
    private String date;//날짜
}
