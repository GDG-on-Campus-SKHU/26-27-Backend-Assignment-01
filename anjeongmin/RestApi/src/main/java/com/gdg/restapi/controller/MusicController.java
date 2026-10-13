package com.gdg.restapi.controller;

import com.gdg.restapi.dto.MusicRequest;
import com.gdg.restapi.dto.MusicResponse;
import com.gdg.restapi.service.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/music")
public class MusicController {
    private final MusicService musicService;

    @PostMapping
    public ResponseEntity<MusicResponse> create(@RequestBody MusicRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(musicService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<MusicResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MusicResponse> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.findById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<MusicResponse> update(@PathVariable("id") Long id, @RequestBody MusicRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(musicService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        musicService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
