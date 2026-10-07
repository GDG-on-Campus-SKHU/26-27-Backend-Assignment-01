package com.gdg.restapi.controller;

import com.gdg.restapi.dto.ScoreRequest;
import com.gdg.restapi.dto.ScoreResponse;
import com.gdg.restapi.service.PlayService;
import com.gdg.restapi.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.midi.MidiUnavailableException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;
    private final PlayService playService;

    // 악보 등록
    @PostMapping
    public ResponseEntity<ScoreResponse> create(@RequestBody ScoreRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(scoreService.create(request));
    }

    // 모든 악보 찾기
    @GetMapping
    public ResponseEntity<List<ScoreResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(scoreService.findAll());
    }

    // id로 악보 찾기
    @GetMapping("/{id}")
    public ResponseEntity<ScoreResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(scoreService.findById(id));
    }

    // id로 악보 수정
    @PatchMapping("/{id}")
    public ResponseEntity<ScoreResponse> update(@PathVariable("id") Long id, @RequestBody ScoreRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(scoreService.update(id, request));
    }

    // id로 악보 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        scoreService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // id로 악보 재생
    @GetMapping("/{id}/play")
    public ResponseEntity<ScoreResponse> playById(@PathVariable("id") Long id) throws MidiUnavailableException, InterruptedException {
        playService.playById(id);
        return ResponseEntity.status(HttpStatus.OK).body(scoreService.findById(id));
    }
}
