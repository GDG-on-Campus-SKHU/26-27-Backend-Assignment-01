package com.gdg.restapi.config;

import com.gdg.restapi.domain.Score;
import com.gdg.restapi.dto.Note;
import com.gdg.restapi.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component // 메모리에 이 클래스를 올리고, CommandLineRunner 실행하도록 함
@RequiredArgsConstructor
public class ScoreDataInitializer implements CommandLineRunner { // 서버가 켜지고 로직 한 번 자동 실행

    private final ScoreRepository scoreRepository;

    @Override
    public void run(String @NonNull ... args) {

        // 비행기 악보
        scoreRepository.save(new Score(null, "비행기", "윤석중", 0, List.of(
                // [1소절] 떳 다 떳 다 비 행 기 (미 레 도 레 미 미 미)
                new Note(List.of(64), 500), new Note(List.of(62), 500),
                new Note(List.of(60), 500), new Note(List.of(62), 500),
                new Note(List.of(64), 500), new Note(List.of(64), 500),
                new Note(List.of(64), 1000), // '기'는 2박자로 길게

                // [2소절] 날 아 라 (레 레 레)
                new Note(List.of(62), 500), new Note(List.of(62), 500),
                new Note(List.of(62), 1000),

                // [3소절] 날 아 라 (미 미 미)
                new Note(List.of(64), 500), new Note(List.of(64), 500),
                new Note(List.of(64), 1000),

                // [4소절] 높 이 높 이 날 아 라 (미 레 도 레 미 미 미)
                new Note(List.of(64), 500), new Note(List.of(62), 500),
                new Note(List.of(60), 500), new Note(List.of(62), 500),
                new Note(List.of(64), 500), new Note(List.of(64), 500),
                new Note(List.of(64), 1000),

                // [5소절] 우 리 비 행 기 (레 레 미 레 도)
                new Note(List.of(62), 500), new Note(List.of(62), 500),
                new Note(List.of(64), 500), new Note(List.of(62), 500),
                new Note(List.of(60), 2000)
        )));

        // 작은별 악보
        scoreRepository.save(new Score(null, "작은별(화음)", "프랑스 민요", 0, List.of(
                // [도 도 솔 솔]
                // C코드(낮은 도,미,솔: 48,52,55) + 멜로디 도(60)
                new Note(List.of(48, 52, 55, 60), 500),
                new Note(List.of(48, 52, 55, 60), 500),

                // C코드(낮은 도,미,솔: 48,52,55) + 멜로디 솔(67)
                new Note(List.of(48, 52, 55, 67), 500),
                new Note(List.of(48, 52, 55, 67), 500),

                // [라 라 솔 - ]
                // F코드(낮은 파,라,도: 41,45,48) + 멜로디 라(69)
                new Note(List.of(41, 45, 48, 69), 500),
                new Note(List.of(41, 45, 48, 69), 500),

                // C코드(낮은 도,미,솔: 48,52,55) + 멜로디 솔(67) - 2박자(1000ms) 유지
                new Note(List.of(48, 52, 55, 67), 1000),

                // [파 파 미 미]
                // F코드(낮은 파,라,도: 41,45,48) + 멜로디 파(65)
                new Note(List.of(41, 45, 48, 65), 500),
                new Note(List.of(41, 45, 48, 65), 500),

                // C코드(낮은 도,미,솔: 48,52,55) + 멜로디 미(64)
                new Note(List.of(48, 52, 55, 64), 500),
                new Note(List.of(48, 52, 55, 64), 500),

                // [레 레 도 - ]
                // G코드(낮은 솔,시,레: 43,47,50) + 멜로디 레(62)
                new Note(List.of(43, 47, 50, 62), 500),
                new Note(List.of(43, 47, 50, 62), 500),

                // C코드(낮은 도,미,솔: 48,52,55) + 멜로디 도(60) - 2박자(1000ms) 유지
                new Note(List.of(48, 52, 55, 60), 1000)
        )));

        // 테트리스 메인 테마 악보
        scoreRepository.save(new Score(null, "테트리스 메인 테마", "러시아 민요", 80, List.of( // 80 = 레트로 신디사이저
                // 1소절 (미 시 도 레 도 시)
                new Note(List.of(76), 400), new Note(List.of(71), 200),
                new Note(List.of(72), 200), new Note(List.of(74), 400),
                new Note(List.of(72), 200), new Note(List.of(71), 200),

                // 2소절 (라 라 도 미 레 도)
                new Note(List.of(69), 400), new Note(List.of(69), 200),
                new Note(List.of(72), 200), new Note(List.of(76), 400),
                new Note(List.of(74), 200), new Note(List.of(72), 200),

                // 3소절 (시~ 도 레 미)
                new Note(List.of(71), 600), new Note(List.of(72), 200),
                new Note(List.of(74), 400), new Note(List.of(76), 400),

                // 4소절 (도 라 라~~)
                new Note(List.of(72), 400), new Note(List.of(69), 400),
                new Note(List.of(69), 800)  // 마지막은 2박자로 길게 마무리
        )));

        log.info("초기 악보 데이터 세팅 완료");
    }
}
