package com.gdg.restapi.service;

import com.gdg.restapi.domain.Score;
import com.gdg.restapi.dto.Note;
import com.gdg.restapi.repository.ScoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlayService {
    private final ScoreRepository scoreRepository;

    // id로 악보 재생
    @Async
    public void playById(Long id) throws MidiUnavailableException, InterruptedException {
        Synthesizer synthesizer = MidiSystem.getSynthesizer();
        synthesizer.open();
        MidiChannel channel = synthesizer.getChannels()[0]; // 트랙 지정(0~15)

        // 악기 선택
        Score score = scoreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 악보입니다."));
        channel.programChange(score.getInstrument());

        // 노트 진행
        List<Note> melody = score.getMelody();
        for (Note note : melody) {
            List<Integer> pitches = note.getPitches();
            Integer duration = note.getDuration();

            if (pitches != null && !pitches.isEmpty()) {
                for (int pitch : pitches) channel.noteOn(pitch, 80);
                Thread.sleep(duration);
                for (int pitch : pitches) channel.noteOff(pitch);
            } else {
                Thread.sleep(duration);
            }
        }
        synthesizer.close();
    }
}
