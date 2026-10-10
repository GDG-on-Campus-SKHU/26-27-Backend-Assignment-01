package com.gdg.restapi.service;

import com.gdg.restapi.domain.Performancekr;
import com.gdg.restapi.dto.PerformancekrRequest;
import com.gdg.restapi.dto.PerformancekrResponse;
import com.gdg.restapi.repository.PerformancekrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor

public class PerformancekrService {
    private final PerformancekrRepository performancekrRepository;

    public PerformancekrResponse create(PerformancekrRequest request) {
        Performancekr performancekr = new Performancekr(null, request .name(),
                request.venue(), request.guest(), request.startDate(),request.endDate());
        return new PerformancekrResponse(performancekrRepository.save(performancekr));
    }

    public List<PerformancekrResponse> findAll() {
        return performancekrRepository.findAll().stream()
                .map(PerformancekrResponse::new)
                .toList();
    }

    public PerformancekrResponse findById(Long id) {
        return new PerformancekrResponse(performancekrRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아티스트입니다.")));
    }

    public PerformancekrResponse update(Long id, PerformancekrRequest request) {
        Performancekr performancekr = performancekrRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아티스트입니다."));
        performancekr.update(request.name(), request.venue(), request.guest(), request.startDate(),request.endDate());
        return new PerformancekrResponse(performancekr);
    }

    public void delete(Long id) {
        if (!performancekrRepository.delete(id)) {
            throw new IllegalArgumentException("존재하지 않는 아티스트입니다.");
        }
    }
}
