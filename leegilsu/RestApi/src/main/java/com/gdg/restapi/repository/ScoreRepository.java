package com.gdg.restapi.repository;

import com.gdg.restapi.domain.Score;
import com.gdg.restapi.dto.Note;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ScoreRepository {
    private final Map<Long, Score> scores = new HashMap<>();
    private long sequence = 0L; // id 부여를 위한 변수

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
