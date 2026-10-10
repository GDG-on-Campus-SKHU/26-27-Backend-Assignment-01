package com.gdg.restapi.service;

import com.gdg.restapi.domain.Score;
import com.gdg.restapi.dto.ScoreRequest;
import com.gdg.restapi.dto.ScoreResponse;
import com.gdg.restapi.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    private static final String NOT_FOUND_MESSAGE = "존재하지 않는 악보입니다.";

    public ScoreResponse create(ScoreRequest request) {
        Score score = new Score(null, request.name(), request.composer(),
                request.instrument(), request.melody());
        return new ScoreResponse(scoreRepository.save(score));
    }

    public List<ScoreResponse> findAll() {
        return scoreRepository.findAll().stream()
                .map(ScoreResponse::new)
                .sorted(Comparator.comparing(ScoreResponse::id).reversed()) // 최신 악보 순 정렬
                .toList();
    }

    public ScoreResponse findById(Long id) {
        return new ScoreResponse(scoreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MESSAGE)));
    }

    public ScoreResponse update(Long id, ScoreRequest request) {
        Score score = scoreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_MESSAGE));

        score.update(request.name(), request.composer(), request.instrument(), request.melody());
        return new ScoreResponse(score);
    }

    public void delete(Long id) {
        if (!scoreRepository.delete(id)) {
            throw new IllegalArgumentException(NOT_FOUND_MESSAGE);
        }
    }
}
