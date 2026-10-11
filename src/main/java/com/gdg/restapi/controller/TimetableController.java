package com.gdg.restapi.controller;

import com.gdg.restapi.dto.TimetableRequest;
import com.gdg.restapi.dto.TimetableResponse;
import com.gdg.restapi.service.TImetableService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/timetable")
public class TimetableController {

    private final TImetableService timetableService;

    @PostMapping
    public ResponseEntity<TimetableResponse> create(@RequestBody TimetableRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(timetableService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<TimetableResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(timetableService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimetableResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(timetableService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TimetableResponse> update(
            @PathVariable("id") Long id,
            @RequestBody TimetableRequest request) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(timetableService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        timetableService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
