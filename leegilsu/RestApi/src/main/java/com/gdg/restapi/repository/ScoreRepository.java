package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Score;
import com.gdg.restapi.dto.Note;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ScoreRepository {
    private final Map<Long, Score> scores = new HashMap<>();
    private long sequence = 0L; // id 부여를 위한 변수

    public ScoreRepository() {

        // 비행기 악보
        save(new Score(null, "비행기", "윤석중", 0, List.of(
                new Note(List.of(64), 500), new Note(List.of(62), 500),
                new Note(List.of(60), 500), new Note(List.of(62), 500)
        )));

        // 작은별 악보
        save(new Score(null, "작은별(화음)", "프랑스 민요", 0, List.of(
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
    }

    public Score save(Score newScore) {
        Score score = new Score(++sequence, newScore.getName(), newScore.getComposer(),
                newScore.getInstrument(), newScore.getMelody());
        scores.put(score.getId(), score);
        return score;
    }

    public List<Score> findAll() {
        return new ArrayList<>(scores.values());
    }

    public Optional<Score> findById(Long id) {
        return Optional.ofNullable(scores.get(id));
    }

    public boolean delete(Long id) {
        return scores.remove(id) != null;
    }
}
