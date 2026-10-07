package com.gdg.restapi.service;

import com.gdg.restapi.domain.Score;
import com.gdg.restapi.dto.ScoreRequest;
import com.gdg.restapi.dto.ScoreResponse;
import com.gdg.restapi.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScoreService {
    private final ScoreRepository scoreRepository;

    public ScoreResponse create(ScoreRequest request) {
        Score score = new Score(null, request.getName(), request.getComposer(),
                request.getInstrument(), request.getMelody());
        return new ScoreResponse(scoreRepository.save(score));
    }

    public List<ScoreResponse> findAll() {
        return scoreRepository.findAll().stream()
                .map(ScoreResponse::new)
                .toList();
    }

    public ScoreResponse findById(Long id) {
        return new ScoreResponse(scoreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 악보입니다.")));
    }

    public ScoreResponse update(Long id, ScoreRequest request) {
        Score score = scoreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 악보입니다."));

        score.update(request.getName(), request.getComposer(), request.getInstrument(), request.getMelody());
        return new ScoreResponse(score);
    }

    public void delete(Long id) {
        if (!scoreRepository.delete(id)) {
            throw new IllegalArgumentException("존재하지 않는 악보입니다.");
        }
    }
}
