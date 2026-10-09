package com.gdg.restapi.service;

import com.gdg.restapi.domain.Music;
import com.gdg.restapi.dto.MusicRequest;
import com.gdg.restapi.dto.MusicResponse;
import com.gdg.restapi.repository.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    public MusicResponse create(MusicRequest request) {
        Music music = new Music(null, request.getNumber(), request.getName(), request.getSinger(), request.getLyricist(), request.getComposer());
        return new MusicResponse(musicRepository.save(music));
    }

    public List<MusicResponse> findAll() {
        return musicRepository.findAll().stream()
                .map(MusicResponse::new)
                .toList();
    }

    public MusicResponse findById(Long id) {
        return new MusicResponse(musicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 노래입니다.")));
    }

    public MusicResponse update(Long id, MusicRequest request) {
        Music music = musicRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 노래입니다."));

        music.update(request.getNumber(), request.getName(), request.getSinger(), request.getLyricist(), request.getComposer());
        return new MusicResponse(music);
    }

    public void delete(Long id) {
        if (!musicRepository.delete(id)) {
            throw new IllegalArgumentException("존재하지 않는 노래입니다.");
        }
    }
}
