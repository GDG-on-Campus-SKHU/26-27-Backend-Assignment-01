package com.gdg.restapi.controller;

import com.gdg.restapi.dto.PerformancekrRequest;
import com.gdg.restapi.dto.PerformancekrResponse;
import com.gdg.restapi.service.PerformancekrService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/performances")
public class PerformancekrController {
    private final PerformancekrService performancekrService;

    @PostMapping
    public ResponseEntity<PerformancekrResponse> create(@RequestBody PerformancekrRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(performancekrService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<PerformancekrResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(performancekrService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PerformancekrResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(performancekrService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PerformancekrResponse> update(@PathVariable("id") Long id, @RequestBody PerformancekrRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(performancekrService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        performancekrService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
