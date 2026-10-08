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
    @Async // 비동기화
    public void playById(Long id) {
        Synthesizer synthesizer = null;
        try {
            synthesizer = MidiSystem.getSynthesizer();
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
                    for (int pitch : pitches) channel.noteOn(pitch, 80); // 건반 누르기
                    Thread.sleep(duration);
                    for (int pitch : pitches) channel.noteOff(pitch); // 건반 떼기
                } else {
                    Thread.sleep(duration);
                }
            }
        } catch (MidiUnavailableException e) { // MIDI 장치를 쓸 수 없음
            System.err.println("오디오 장치를 열 수 없습니다." + e.getMessage());
        } catch (InterruptedException e) { // 재생이 강제로 멈춤
            System.out.println("음악 재생이 강제 중단되었습니다.");
            Thread.currentThread().interrupt();
        } catch (Exception e) { // 그 외 예외
            System.err.println("알 수 없는 에러가 발생했습니다." + e.getMessage());
        }
        synthesizer.close();
    }
}
