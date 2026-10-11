package com.gdg.restapi.service;

import com.gdg.restapi.domain.Timetable;
import com.gdg.restapi.dto.TimetableRequest;
import com.gdg.restapi.dto.TimetableRequest;
import com.gdg.restapi.dto.TimetableResponse;
import com.gdg.restapi.repository.TimetableRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TImetableService {

    private final TimetableRepository timetableRepository;

    public TimetableResponse create(TimetableRequest request) {
        Timetable timetable = new Timetable(
                0L,
                request.getDay(),
                request.getName()
        );

        return new TimetableResponse(timetableRepository.save(timetable));
    }

    public List<TimetableResponse> findAll() {
        return timetableRepository.findAll().stream()
                .map(TimetableResponse::new)
                .toList();
    }

    public TimetableResponse findById(Long id) {
        return new TimetableResponse(timetableRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 시간표입니다.")));
    }

    public TimetableResponse update(Long id, TimetableRequest request) {
        Timetable timetable = timetableRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 시간표입니다."));

        timetable.update(request.getDay(), request.getName());

        return new TimetableResponse(timetable);
    }

    public void delete(Long id) {
        if (!timetableRepository.delete(id)) {
            throw new IllegalArgumentException("존재하지 않는 시간표입니다.");
        }
    }
}
